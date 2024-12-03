package use_case.gameState;

import java.util.ArrayList;

import entity.AbstractGame;
import entity.QuestionAnswer;

/**
 * GameState management interface.
 */
public interface GameStateInputBoundary {
    /**
     * Retrieves the current game instance.
     *
     * @return The current Game object
     */
    AbstractGame getGame();

    /**
     * Starts the game and prepares the first question.
     * @param difficulty corresponds to the button pressed on the difficulty page
     */
    void startGame(int difficulty);

    /**
     * Processes a submitted answer and updates game state accordingly.
     *
     * @param userAnswer The answer submitted by the user
     */
    void executeAnswerSubmit(String userAnswer);

    /**
     * Sets the questions answers for the game to take place.
     * @param questionsAnswers - the array list of question and answer pairs
     */
    void setQuestionsAnswers(ArrayList<QuestionAnswer> questionsAnswers);

    /**
     * Gather the difficulty required for the current game.
     */
    void getGameDifficulty();

    /**
     * Moves to next question.
     * @param justSubmitted indicates whether or not the user just submitted an answer or not
     */
    void moveAnswerToNextQuestion(boolean justSubmitted);

    /**
     * Gets the user's score for the current game.
     * @return the score for the current game
     */
    int getScore();

    /**
     * Gets the user's total time for the current game.
     * @return the total time for the current game
     */
    int getTotalTime();

    /**
     * Gets the user's average time for the current game.
     * @return the average time for the current game
     */
    int getAvgTime();
}
