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

    public void setDifficulty() {
        // change view by calling the interactor .... to eventually change the game curr view.
        gameStateInteractor.gatherDifficultyForGame();
    }

    /**
     * Starts the game after the file is loaded.
     * @param difficulty - corresponds to the button that is pressed on the difficulty page
     */
    public void startGame(int difficulty) {
        gameStateInteractor.startGame(difficulty);
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

