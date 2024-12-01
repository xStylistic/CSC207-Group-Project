package use_case.retrieveFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.QuestionAnswer;
import entity.User;

/**
 * The "Use Case Interactor" for our two File-related use cases of refreshing
 * the contents of the File and saving the contents of the File. Since they
 * are closely related, we have combined them here for simplicity.
 */
public class FileInteractor implements FileInputBoundary {
    private final FileDataAccessInterface fileDataAccessInterface;
    private final FileOutputBoundary fileOutputBoundary;
    private final User user = new User("jonathan_calver2", "abc123");
    private File file;
    private final ArrayList<QuestionAnswer> questionsAnswers;

    public FileInteractor(FileDataAccessInterface fileDataAccessInterface,
                          FileOutputBoundary fileOutputBoundary) {
        this.fileDataAccessInterface = fileDataAccessInterface;
        this.fileOutputBoundary = fileOutputBoundary;
        this.questionsAnswers = new ArrayList<>();
    }

    /**
     * Executes the retrieve File use case.
     *
     * @return file
     */
    @Override
    public File executeRetrieval() {
        try {
            this.file = fileDataAccessInterface.requestFile(user);
            fileOutputBoundary.prepareSuccessView(this.file);

            try {
                final List<String> lines = Files.readAllLines(file.toPath());

                final Iterator<String> iterator = lines.iterator();
                if (iterator.hasNext()) {
                    iterator.next();
                }

                while (iterator.hasNext()) {
                    final String[] line = iterator.next().split("\t");

                    if (line.length == 2) {
                        questionsAnswers.add(new QuestionAnswer(line[0], line[1]));
                    }
                }
            }
            catch (IOException ex) {
                throw new RuntimeException("Error reading the file: " + file.getName(), ex);
            }
        }
        catch (DataAccessException ex) {
            fileOutputBoundary.prepareFailView(ex.getMessage());
        }
        return file;
    }

    /**
     * Handler function for querying file name.
     * @return string
     */
    public String getFileName() {
        return file.getName();
    }

    @Override
    public ArrayList<QuestionAnswer> getQuestionsAnswers() {
        return questionsAnswers;
    }
}
