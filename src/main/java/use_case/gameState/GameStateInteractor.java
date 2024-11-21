package use_case.gameState;

import entity.Game;
import entity.QuestionAnswer;
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
    private Game game;

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
    public Game getGame() {
        return game;
    }

    /**
     * Starts the game by preparing the first question view.
     */
    @Override
    public void startGame() {
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
        final QuestionAnswer currentQuestionAnswer = game.getCurrentQuestion();
        if (currentQuestionAnswer == null) {
            gameOutputBoundary.prepareEndGameView();
        }
        else {
//            game.submitAnswer(userAnswer);
            if (currentQuestionAnswer.validateAnswer()) {
                gameOutputBoundary.prepareAnswerResultView(currentQuestionAnswer);
            }
            else {
                gameOutputBoundary.prepareAnswerConfirmView(currentQuestionAnswer);
            }

            if (game.isGameFinished()) {
                gameOutputBoundary.prepareEndGameView();
            }
            else {
                gameOutputBoundary.prepareQuestionView(game.getCurrentQuestion());
            }
        }
    }

    @Override
    public void setQuestionsAnswers(ArrayList<QuestionAnswer> questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }
}
