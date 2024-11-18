package interface_adapter.game;

import java.io.File;

import entity.QuestionAnswer;
import use_case.game.GameInputBoundary;

/**
 * Controller for our File related Use Cases.
 */
public class GameController {

    private final GameInputBoundary gameInteractor;

    public GameController(GameInputBoundary gameInteractor) {
        this.gameInteractor = gameInteractor;
    }

    /**
     * Executes the File related Use Cases.
     *
     * @return File that the user gave
     */
    public File execute() {
        return gameInteractor.executeRetrieval();
    }

    /**
     * Starts the game after the file is loaded.
     */
    public void startGame() {
        gameInteractor.startGame();
    }

    /**
     * Submits the user's answer to the current question by delegating to the interactor.
     *
     * @param userAnswer The answer provided by the user.
     */
    public void submitAnswer(String userAnswer) {
        gameInteractor.executeAnswerSubmit(userAnswer);
    }
}