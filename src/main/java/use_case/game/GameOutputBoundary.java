package use_case.game;

import java.io.File;
import java.util.List;

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

    void prepareQuestionView(QuestionAnswer firstQuestion);

    void prepareEndGameView();

    void prepareAnswerResultView(QuestionAnswer questionAnswer);

    void prepareAnswerConfirmView(QuestionAnswer currentQuestionAnswer);

    void prepareDifficultyView();

    void prepareAnimalRewardView();

    void setDisplayAnimalsToGameState(List<Animal> currentListAnimalsToDisplay);
}
