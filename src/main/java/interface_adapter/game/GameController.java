package interface_adapter.game;

import java.io.File;

import entity.QuestionAnswer;
import use_case.game.GameInputBoundary;
import use_case.gameState.GameStateInputBoundary;
import use_case.gameState.GameStateInteractor;

/**
 * Controller for our File related Use Cases.
 */
public class GameController {
    private final GameInputBoundary gameInteractor;
    private GameStateInputBoundary gameStateInteractor;

    public GameController(GameInputBoundary gameInteractor, GameStateInputBoundary gameStateInteractor) {
        this.gameInteractor = gameInteractor;
        this.gameStateInteractor = gameStateInteractor;
    }

    /**
     * Executes the File related Use Cases.
     */
    public void execute() {
        gameInteractor.executeRetrieval();
        gameStateInteractor.setQuestionsAnswers(gameInteractor.getQuestionsAnswers());
    }

    /**
     * Starts the game after the file is loaded.
     */
    public void startGame() {
        gameStateInteractor.startGame();
    }

    /**
     * Submits the user's answer to the current question by delegating to the interactor.
     *
     * @param userAnswer The answer provided by the user.
     */
    public void submitAnswer(String userAnswer) {
        gameStateInteractor.executeAnswerSubmit(userAnswer);
    }

    public String getFileName() {
        return gameInteractor.getFileName();
    }
}

