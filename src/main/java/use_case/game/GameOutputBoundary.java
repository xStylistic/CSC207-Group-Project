package use_case.game;

import java.io.File;
import java.util.List;

import entity.AbstractGame;
import entity.Animal;
import entity.QuestionAnswer;

/**
 * The output boundary for the Login Use Case.
 */
public interface GameOutputBoundary {
    /**
     * Prepares the success view for the File related Use Cases.
     * @param message the output data
     */
    void prepareSuccessView(File message);

    /**
     * Prepares the failure view for the File and Question related Use Cases.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Prepares the question view for the current game and question.
     * @param questionAnswer the current question to display in the question view
     * @param game the current game that is being played
     */
    void prepareQuestionView(QuestionAnswer questionAnswer, AbstractGame game);

    /**
     * Prepares the view for the end of the game.
     * @param game the game that is being ended
     */
    void prepareEndGameView(AbstractGame game);

    /**
     * Prepares the answer result view after user submits an answer.
     * @param questionAnswer the questionAnswer that was just answered
     */
    void prepareAnswerResultView(QuestionAnswer questionAnswer);

    /**
     * Prepares the view that sets the difficulty view.
     */
    void prepareDifficultyView();

    /**
     * Prepares the view for rewarding the user with a new animal.
     */
    void prepareAnimalRewardView();

    /**
     * Sets the animals to be displayed onto the current game state.
     * @param currentListAnimalsToDisplay the list of animals to be displayed
     */
    void setDisplayAnimalsToGameState(List<Animal> currentListAnimalsToDisplay);
}
