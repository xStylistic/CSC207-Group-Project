package use_case.game;

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
     * @return
     */
    File executeRetrieval();

    /**
     * Returns the Game instance.
     *
     * @return The Game object.
     */
    Game getGame();

    /**
     * Starts the game by preparing the first question view.
     */
    void startGame();

    /**
     * Processes the user's answer and determines correctness.
     *
     * @param userAnswer The user's answer.
     */
    void executeAnswerSubmit(String userAnswer);

    String getFileName();

}
