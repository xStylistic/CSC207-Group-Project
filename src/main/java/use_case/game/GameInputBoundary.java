package use_case.game;

import entity.Game;
import entity.QuestionAnswer;

import java.io.File;
import java.util.ArrayList;

/**
 * The Input Boundary for our note-related use cases. Since they are closely related,
 * we have included them both in the same interface for simplicity.
 */
public interface GameInputBoundary {

    /**
     * Executes the refresh note use case.
     *
     * @return the file
     */
    File executeRetrieval();

//    /**
//     * Returns the Game instance.
//     *
//     * @return The Game object.
//     */
//    Game getGame();
//
//    /**
//     * Starts the game by preparing the first question view.
//     */
//    void startGame();
//
//    /**
//     * Processes the user's answer and determines correctness.
//     *
//     * @param userAnswer The user's answer.
//     */
//    void executeAnswerSubmit(String userAnswer);

    String getFileName();

    /**
     * getter method for other interactors.
     * @return question answer list
     */
    ArrayList<QuestionAnswer> getQuestionsAnswers();
}
