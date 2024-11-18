package use_case.question;

import entity.Game;

import java.io.File;

/**
 * The Input Boundary for our note-related use cases. Since they are closely related,
 * we have included them both in the same interface for simplicity.
 */
public interface GameInputBoundary {

    /**
     * Executes the refresh note use case.
     *
     * @return File that the user gave
     */
    File executeRetrieval();

    Game getGame();
}
