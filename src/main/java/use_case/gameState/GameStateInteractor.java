package use_case.gameState;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import entity.AbstractGame;
import entity.Animal;
import entity.EasyGame;
import entity.HardGame;
import entity.MediumGame;
import entity.QuestionAnswer;
import use_case.game.GameOutputBoundary;
import view.EasyQuestionView;
import view.HardQuestionView;
import view.MediumQuestionView;

/**
 * Individualized logic for game interactions.
 */
public class GameStateInteractor implements GameStateInputBoundary {
    private static final String INACTIVEGAMEMSG = "The game is not active";
    private final GameOutputBoundary gameOutputBoundary;
    private ArrayList<QuestionAnswer> questionsAnswers;
    private AbstractGame game;

    public GameStateInteractor(GameOutputBoundary gameOutputBoundary
    ) {
        this.gameOutputBoundary = gameOutputBoundary;
        this.game = null;
    }

    public GameStateInteractor(GameOutputBoundary gameOutputBoundary,
                               ArrayList<QuestionAnswer> questionsAnswers) {
        this.gameOutputBoundary = gameOutputBoundary;
        this.game = null;
        this.questionsAnswers = questionsAnswers;
    }

    /**
     * Returns the Game instance.
     *
     * @return The Game object.
     */
    @Override
    public AbstractGame getGame() {
        return game;
    }

    /**
     * Starts the game by preparing the first question view.
     */
    @Override
    public void startGame(int difficulty) {
        // Make the game based on what difficulty the game is
        switch (difficulty) {
            case 0:
                this.game = new EasyGame(questionsAnswers);
                break;
            case 1:
                this.game = new MediumGame(questionsAnswers);
                break;
            case 2:
                this.game = new HardGame(questionsAnswers);
                break;
            default:
                this.game = null;
                System.out.println("INVALID DIFFICULTY");
                break;
        }

        if (game != null) {
            this.updateGameStateWithNewDisplayAnimals();

            if (game instanceof EasyGame) {
                this.game.getTimer().start(() -> SwingUtilities.invokeLater(() -> EasyQuestionView.handleGameTimer()));
            }
            else if (game instanceof MediumGame) {
                this.game.getTimer().start(
                        () -> SwingUtilities.invokeLater(() -> MediumQuestionView.handleGameTimer()));
            }
            else if (game instanceof HardGame) {
                this.game.getTimer().start(() -> SwingUtilities.invokeLater(() -> HardQuestionView.handleGameTimer()));
            }

            final QuestionAnswer firstQuestion = game.getCurrentQuestion();
            gameOutputBoundary.prepareQuestionView(firstQuestion, this.game);
        }
        else {
            gameOutputBoundary.prepareFailView(INACTIVEGAMEMSG);
        }
    }

    /**
     * Processes the user's answer and proceeds to the next question or ends the game.
     *
     * @param userAnswer The user's submitted answer.
     */
    @Override
    public void executeAnswerSubmit(String userAnswer) {
        if (game == null) {
            gameOutputBoundary.prepareFailView(INACTIVEGAMEMSG);
        }

        // Execute Answer Submit Logic
        final QuestionAnswer currentQuestionAnswer = game.getCurrentQuestion();
        currentQuestionAnswer.setUserAnswer(userAnswer);
        if (currentQuestionAnswer == null) {
            gameOutputBoundary.prepareEndGameView(game);
        }
        else {
            if (currentQuestionAnswer.validateAnswer()) {
                gameOutputBoundary.prepareAnswerResultView(currentQuestionAnswer);
                System.out.println("Updates Animal");
                game.updateQuestionAnswersCorrect(true);
                game.updateQuestionAnswerTimes(currentQuestionAnswer.getTimer().getTimeLimit()
                            - currentQuestionAnswer.getTimer().getRemainingTime());
            }
            else {
                gameOutputBoundary.prepareAnswerResultView(currentQuestionAnswer);
                System.out.println("Calls updateQuestion False");
                game.updateQuestionAnswersCorrect(false);
                game.updateQuestionAnswerTimes(currentQuestionAnswer.getTimer().getTimeLimit()
                            - currentQuestionAnswer.getTimer().getRemainingTime());
            }

        }
    }

    /**
     * Either move to the next question from the reward page or go to the reward page.
     * @param justSubmitted indicates the current page was the submit button, therefore we should test for reward page
     */
    public void moveAnswerToNextQuestion(boolean justSubmitted) {
        if (game == null) {
            gameOutputBoundary.prepareFailView(INACTIVEGAMEMSG);
        }

        // Execute Answer Submit Logic
        QuestionAnswer currentQuestionAnswer = game.getCurrentQuestion();

        // Move to rewards page
        if (currentQuestionAnswer.isCorrect() && justSubmitted) {
            this.updateGameStateWithNewDisplayAnimals();
            gameOutputBoundary.prepareAnimalRewardView();
        }
        // The call from Rewards page to go to the next question
        else if (!justSubmitted) {
            game.moveToNextQuestion();
            // check if game ended
            if (game.isGameFinished()) {
                gameOutputBoundary.prepareEndGameView(this.game);
            }
            else {
                currentQuestionAnswer = game.getCurrentQuestion();
                gameOutputBoundary.prepareQuestionView(currentQuestionAnswer, this.game);
            }
        }
        else if (!currentQuestionAnswer.isCorrect() && justSubmitted) {
            this.updateGameStateWithNewDisplayAnimals();

            // Incorrect so we need to go to the next question for easy and medium
            if (game instanceof EasyGame || game instanceof MediumGame) {
                game.moveToNextQuestion();

                // Check if game ended
                if (game.isGameFinished()) {
                    gameOutputBoundary.prepareEndGameView(this.game);
                }
                else {
                    // if not, go to the next question
                    currentQuestionAnswer = game.getCurrentQuestion();
                    gameOutputBoundary.prepareQuestionView(currentQuestionAnswer, this.game);
                }
            }
            // Incorrect for hard game ends everything
            else {
                gameOutputBoundary.prepareEndGameView(this.game);
            }
        }
    }

    /**
     * Function to update game with animals.
     */
    public void updateGameStateWithNewDisplayAnimals() {
        gameOutputBoundary.setDisplayAnimalsToGameState(this.getCurrentListAnimalsToDisplay());
    }

    /**
     * Function to return current list of animals that we should display for each view in the background.
     * @return animalsShouldDisplay - the list of animals we should display on each view in the background.
     */
    public List<Animal> getCurrentListAnimalsToDisplay() {
        final List<Animal> currentAnimals = game.getAnimalFarm().getCurrentAnimals();
        return currentAnimals;
    }

    @Override
    public void setQuestionsAnswers(ArrayList<QuestionAnswer> questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }

    @Override
    public void getGameDifficulty() {
        gameOutputBoundary.prepareDifficultyView();
    }

    /**
     * Gets the number of correctly answered questions.
     * @return the number of correct answers.
     */
    public int getScore() {
        return this.game.getScore();
    }

    /**
     * Gets the number of correctly answered questions.
     * @return the number of correct answers.
     */
    public int getAvgTime() {
        return this.game.getAvgTime();
    }

    /**
     * Gets the number of correctly answered questions.
     * @return the number of correct answers.
     */
    public int getTotalTime() {
        return this.game.getTotalTime();
    }

    public ArrayList<QuestionAnswer> getQuestionsAnswers() {
        return this.questionsAnswers;
    }
}
