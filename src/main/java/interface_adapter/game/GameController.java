package interface_adapter.game;

import use_case.game.GameInputBoundary;
import use_case.gameState.GameStateInputBoundary;

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
     * Sets the game difficulty.
     */
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

    /**
     * Function to go to the next question from an answer
     */
    public void goToNextQuestion(boolean justSubmitted) {
        gameStateInteractor.moveAnswerToNextQuestion(justSubmitted);
    }

    public String getFileName() {
        return gameInteractor.getFileName();
    }
}

