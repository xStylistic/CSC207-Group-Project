package interface_adapter.game;

import java.io.File;

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
}
