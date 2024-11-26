package use_case.gameState;

import entity.AbstractGame;
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
     * Sets the questions answers for the game to take place
     * @param questionsAnswers - the array list of question and answer pairs
     */
    void setQuestionsAnswers(ArrayList<QuestionAnswer> questionsAnswers);

    void gatherDifficultyForGame();

    void moveAnswerToNextQuestion(boolean justSubmitted);
}