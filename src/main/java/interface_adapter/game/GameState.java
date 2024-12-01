package interface_adapter.game;

import entity.Animal;
import entity.QuestionAnswer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The State for a File.
 * <p>For this example, ...</p>
 * difficulty = 0 - EASY
 * difficulty = 0 - MEDIUM
 * difficulty = 0 - HARD
 */
public class GameState {
    private File file;
    private String error;
    private QuestionAnswer currentQuestionAnswer;
    private Integer currentRemainingTime;
    private String message;
    private int difficulty;

    private List<Animal> animalsToDisplay;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setError(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }

    public void setCurrentQuestionAnswer(QuestionAnswer currentQuestionAnswer) {
        this.currentQuestionAnswer = currentQuestionAnswer;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public QuestionAnswer getCurrentQuestionAnswer() {
        return currentQuestionAnswer;
    }

    public void setCurrentRemainingTime(Integer currentRemainingTime) {
        this.currentRemainingTime = currentRemainingTime;
    }

    public Integer getCurrentRemainingTime() {
        return currentRemainingTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Function sets the animals to display in game state.
     * @param animalsToDisplay the current list of animals
     */
    public void setAnimalsToDisplay(List<Animal> animalsToDisplay) {
        this.animalsToDisplay = animalsToDisplay;
    }

    /**
     * Getter to allow rest of game to have access to what to display.
     * @return animalsToDisplay
     */
    public List<Animal> getAnimalsToDisplay() {
        return animalsToDisplay;
    }
}