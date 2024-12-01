package interface_adapter.game;

import java.io.File;
import java.util.List;

import entity.Animal;
import entity.QuestionAnswer;
import use_case.retrieveFile.FileOutputBoundary;

/**
 * The presenter for our File viewing and editing program.
 */
public class GamePresenter implements FileOutputBoundary {

    private final GameViewModel gameViewModel;

    public GamePresenter(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    // Function to prepare difficulty view
    public void prepareDifficultyView() {
        gameViewModel.setViewName("difficulty");
        gameViewModel.firePropertyChanged("pageChange");
    }

    /**
     * Prepares the success view for the File related Use Cases.
     *
     * @param file the output data
     */
    @Override
    public void prepareSuccessView(File file) {
        gameViewModel.getState().setFile(file);
        gameViewModel.getState().setError(null);
        gameViewModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the File related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        gameViewModel.getState().setError(errorMessage);
        gameViewModel.firePropertyChanged();
    }

    /**
     * Trigger question result view.
     * @param questionAnswer the question answer variable which includes the user answers
     */
    @Override
    public void prepareAnswerResultView(QuestionAnswer questionAnswer) {
        if (Boolean.TRUE.equals(questionAnswer.isCorrect())) {
            gameViewModel.getState().setMessage("Correct! Well done. The answer is " + questionAnswer.getCorrectAnswer());
        }
        else {
            gameViewModel.getState().setMessage("Incorrect. The correct answer was: "
                    + questionAnswer.getCorrectAnswer());
        }
        gameViewModel.firePropertyChanged("message");
    }

    /**
     * Prepares the next question view.
     *
     * @param questionAnswer The next question to display.
     * @param answerTime The time limit of the next question
     */
    public void prepareQuestionView(QuestionAnswer questionAnswer, Integer answerTime) {
        gameViewModel.getState().setCurrentQuestionAnswer(questionAnswer);
        gameViewModel.getState().setCurrentRemainingTime(answerTime);
        gameViewModel.getState().setMessage("Answer the question below:");
        gameViewModel.setViewName("questions");
        gameViewModel.firePropertyChanged("pageChange");
    }

    @Override
    public void prepareAnswerConfirmView(QuestionAnswer currentQuestionAnswer) {
        gameViewModel.getState().setMessage("Is your answer: " + currentQuestionAnswer.getUserAnswer()
                + "\n the same as the correct answer: " + currentQuestionAnswer.getCorrectAnswer() + "?");
        gameViewModel.firePropertyChanged();
    }

    /**
     * Prepare reward view
     */
    public void prepareAnimalRewardView() {
        gameViewModel.setViewName("reward");
        gameViewModel.firePropertyChanged("pageChange");
    }

    /**
     * Prepares the view for the end of the game.
     */
    public void prepareEndGameView() {
        gameViewModel.getState().setMessage("Game over! Thanks for playing.");
        gameViewModel.getState().setCurrentQuestionAnswer(null);
        gameViewModel.firePropertyChanged();
        // Set the ending screen
        gameViewModel.setViewName("end");
        gameViewModel.firePropertyChanged("pageChange");
    }

    /**
     * Updates the current state with the latest animal list state.
     * @param animals the list of animals
     */
    public void setDisplayAnimalsToGameState(List<Animal> animals) {
        gameViewModel.getState().setAnimalsToDisplay(animals);
        gameViewModel.firePropertyChanged("displayAnimals");
    }
}
