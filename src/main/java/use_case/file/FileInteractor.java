package use_case.file;

import entity.User;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public FileInteractor(FileDataAccessInterface fileDataAccessInterface,
                          FileOutputBoundary fileOutputBoundary) {
        this.fileDataAccessInterface = fileDataAccessInterface;
        this.fileOutputBoundary = fileOutputBoundary;
        this.file = null;
    }

    /**
     * Executes the retrieve File use case.
     *
     * @return
     */
    @Override
    public File executeRetrieval() {
        try {
            this.file = fileDataAccessInterface.requestFile(user);
            fileOutputBoundary.prepareSuccessView(this.file);

            Map<String, String> questionsAnswers = new HashMap<>();

            try {
                List<String> lines = Files.readAllLines(file.toPath());

                Iterator<String> iterator = lines.iterator();
                if (iterator.hasNext()) {
                    iterator.next();
                }

                while (iterator.hasNext()) {
                    String[] line = iterator.next().split("\t");

                    if (line.length == 2) {
                        questionsAnswers.put(line[0], line[1]);
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException("Error reading the file: " + file.getName(), ex);
            }
            System.out.println(questionsAnswers);



        } catch (DataAccessException ex) {
            fileOutputBoundary.prepareFailView(ex.getMessage());
        }
        return null;
    }
}
