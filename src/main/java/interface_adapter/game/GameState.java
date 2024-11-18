package interface_adapter.game;

import entity.QuestionAnswer;

import java.io.File;

/**
 * The State for a File.
 * <p>For this example, ...</p>
 */
public class GameState {
    private File file;
    private String error;
    private QuestionAnswer currentQuestionAnswer;
    private String message;

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

    public QuestionAnswer getCurrentQuestionAnswer() {
        return currentQuestionAnswer;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}