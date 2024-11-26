package use_case.gameState;

import entity.*;
import kotlin.jvm.Throws;
import use_case.game.GameDataAccessInterface;
import use_case.game.GameOutputBoundary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Individualized logic for game interactions
 */
public class GameStateInteractor implements GameStateInputBoundary {
    private final GameOutputBoundary gameOutputBoundary;
    private ArrayList<QuestionAnswer> questionsAnswers;
    private AbstractGame game;

    public GameStateInteractor(GameOutputBoundary gameOutputBoundary
    ) {
        this.gameOutputBoundary = gameOutputBoundary;
        this.game = null;
    }

    public GameStateInteractor(GameOutputBoundary gameOutputBoundary,
                               ArrayList<QuestionAnswer> questionsAnswers
                               ) {
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
     * Prepares for starting the game by getting the difficulty
     */
    public void gatherDifficultyForGame() {
        gameOutputBoundary.prepareDifficultyView();
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
            final QuestionAnswer firstQuestion = game.getCurrentQuestion();
            gameOutputBoundary.prepareQuestionView(firstQuestion);
        }
        else {
            gameOutputBoundary.prepareFailView("The game is not active");
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
            gameOutputBoundary.prepareFailView("The game is not active");
        }

        // Execute Answer Submit Logic

        final QuestionAnswer currentQuestionAnswer = game.getCurrentQuestion();
        currentQuestionAnswer.setUserAnswer(userAnswer);
        if (currentQuestionAnswer == null) {
            gameOutputBoundary.prepareEndGameView();
        }
        else {
            if (currentQuestionAnswer.validateAnswer()) {
                gameOutputBoundary.prepareAnswerResultView(currentQuestionAnswer);
                game.updateQuestionAnswersCorrect(true);
                if (!(game instanceof EasyGame)) {
                    game.updateQuestionAnswerTimes(game.getTimer().getTimeLimit() - game.getTimer().getRemainingTime());
                }

            }
            else {
                gameOutputBoundary.prepareAnswerResultView(currentQuestionAnswer);
                game.updateQuestionAnswersCorrect(false);
                if (!(game instanceof EasyGame)) {
                    game.updateQuestionAnswerTimes(game.getTimer().getTimeLimit() - game.getTimer().getRemainingTime());
                }
            }

        }
    }

    /**
     * either move to the next question from the reward page or go to the reward page
     * @param justSubmitted indicates the current page was the submit button, therefore we should test for reward page
     */
    public void moveAnswerToNextQuestion(boolean justSubmitted)
    {
        if (game == null) {
            gameOutputBoundary.prepareFailView("The game is not active");
        }
        if (game.isGameFinished()) {
            gameOutputBoundary.prepareEndGameView();
        }
        else {
            // Execute Answer Submit Logic
            QuestionAnswer currentQuestionAnswer = game.getCurrentQuestion();

            if (game instanceof EasyGame || game instanceof MediumGame) // EASY GAME or MEDIUM GAME
            {
                if (currentQuestionAnswer.validateAnswer() && justSubmitted) // if correct, go to rewards page
                {
                    gameOutputBoundary.prepareAnimalRewardView();
                }
                else    // Go to next question
                {
                    game.moveToNextQuestion();
                    currentQuestionAnswer = game.getCurrentQuestion();
                    gameOutputBoundary.prepareQuestionView(currentQuestionAnswer);
                }
            }
            else // HARD GAME
            {
                if (currentQuestionAnswer.validateAnswer()) // If correct go to rewards page
                {
                    gameOutputBoundary.prepareAnimalRewardView();
                }
                else // Game over if one incorrect
                {
                    gameOutputBoundary.prepareEndGameView();
                }
            }
        }

    }

    @Override
    public void setQuestionsAnswers(ArrayList<QuestionAnswer> questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }
}
