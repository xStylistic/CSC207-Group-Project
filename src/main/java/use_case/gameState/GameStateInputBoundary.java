package use_case.gameState;

import entity.Game;
import entity.QuestionAnswer;

import java.util.ArrayList;

/**
 * GameState management interface
 */
public interface GameStateInputBoundary {
    /**
     * Retrieves the current game instance.
     *
     * @return The current Game object
     */
    Game getGame();

    /**
     * Starts the game and prepares the first question.
     */
    void startGame();

    /**
     * Processes a submitted answer and updates game state accordingly.
     *
     * @param userAnswer The answer submitted by the user
     */
    void executeAnswerSubmit(String userAnswer);

    /**
     * Sets the questions answers for the game to take place
     * @param questionsAnswers - the array list of question and answer pairs
     */
    void setQuestionsAnswers(ArrayList<QuestionAnswer> questionsAnswers);
}