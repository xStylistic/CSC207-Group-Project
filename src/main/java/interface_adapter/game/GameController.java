package interface_adapter.game;

import use_case.game.GameInputBoundary;

import java.io.File;

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
     */
    public File execute() {
        return gameInteractor.executeRetrieval();
    }

    public String getFileName() {
        return gameInteractor.getFileName();
    }
}
