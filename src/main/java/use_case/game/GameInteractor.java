package use_case.game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.QuestionAnswer;

/**
 * The "Use Case Interactor" for our two File-related use cases of refreshing
 * the contents of the File and saving the contents of the File. Since they
 * are closely related, we have combined them here for simplicity.
 */
public class GameInteractor implements GameInputBoundary {
    private final GameDataAccessInterface gameDataAccessInterface;
    private final GameOutputBoundary gameOutputBoundary;
    private File file;
    private ArrayList<QuestionAnswer> questionsAnswers;

    public GameInteractor(GameDataAccessInterface gameDataAccessInterface,
                          GameOutputBoundary gameOutputBoundary) {
        this.gameDataAccessInterface = gameDataAccessInterface;
        this.gameOutputBoundary = gameOutputBoundary;
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
            this.file = gameDataAccessInterface.requestFile();
            gameOutputBoundary.prepareSuccessView(this.file);

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
            gameOutputBoundary.prepareFailView(ex.getMessage());
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

    public void setQuestionsAnswers(ArrayList<QuestionAnswer> questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }

}
