package use_case.gameStateInteractorTest;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.game.GameInteractor;
import use_case.game.GameOutputBoundary;
import use_case.gameState.GameStateInteractor;
import view.GameView;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class GameStateInteractorTest {
    private GameOutputBoundary mockOutputBoundary;
    private GameStateInteractor gameStateInteractor;
    private ArrayList<QuestionAnswer> mockQuestionsAnswers;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testStartGameWithValidDifficulty() {
        gameStateInteractor.startGame(0); // EasyGame
        assertEquals(EasyGame.class, gameStateInteractor.getGame().getClass());

        gameStateInteractor.startGame(1); // MediumGame
        assertEquals(MediumGame.class, gameStateInteractor.getGame().getClass());

        gameStateInteractor.startGame(2); // HardGame
        assertEquals(HardGame.class, gameStateInteractor.getGame().getClass());
    }

    @Test
    void testStartGameWithInvalidDifficulty() {
        gameStateInteractor.startGame(3); // Invalid difficulty
        assertNull(gameStateInteractor.getGame());
    }

    @Test
    void testExecuteAnswerSubmitCorrectAnswer() {
        gameStateInteractor.startGame(0); // EasyGame
        gameStateInteractor.executeAnswerSubmit("4");
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");

        assertTrue(question.isCorrect());
    }

    @Test
    void testExecuteAnswerSubmitIncorrectAnswer() {
        gameStateInteractor.startGame(0); // EasyGame
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");

        gameStateInteractor.executeAnswerSubmit("5");

        assertFalse(question.isCorrect());
    }

    @Test
    void testGetScore() {
        gameStateInteractor.startGame(0); // EasyGame
        AbstractGame game = gameStateInteractor.getGame();
        game.updateQuestionAnswersCorrect(true);
        game.updateQuestionAnswersCorrect(true);

        assertEquals(2, gameStateInteractor.getScore());
    }

    @Test
    void testGetAvgTime() {
        gameStateInteractor.startGame(0); // EasyGame
        AbstractGame game = gameStateInteractor.getGame();
        game.updateQuestionAnswerTimes(10);
        game.updateQuestionAnswerTimes(20);

        assertEquals(15, gameStateInteractor.getAvgTime());
    }

    @Test
    void testGetTotalTime() {
        gameStateInteractor.startGame(0); // EasyGame
        AbstractGame game = gameStateInteractor.getGame();
        game.updateQuestionAnswerTimes(10);
        game.updateQuestionAnswerTimes(20);

        assertEquals(30, gameStateInteractor.getTotalTime());
    }

    @Test
    void testMoveAnswerToNextQuestionCorrectAnswer() {
        gameStateInteractor.startGame(0); // EasyGame
        AbstractGame game = gameStateInteractor.getGame();
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");

        gameStateInteractor.executeAnswerSubmit("4");
        gameStateInteractor.moveAnswerToNextQuestion(true);

        assertTrue(question.isCorrect());
        assertNotNull(game.getCurrentQuestion());
    }

    @Test
    void testMoveAnswerToNextQuestionIncorrectAnswer() {
        gameStateInteractor.startGame(0); // EasyGame
        AbstractGame game = gameStateInteractor.getGame();
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");

        gameStateInteractor.executeAnswerSubmit("5");
        gameStateInteractor.moveAnswerToNextQuestion(true);

        assertFalse(question.isCorrect());
        assertNotNull(game.getCurrentQuestion());
    }

    @Test
    void testGameEndsAfterAllQuestions() {
        gameStateInteractor.startGame(0); // EasyGame
        AbstractGame game = gameStateInteractor.getGame();
        QuestionAnswer question1 = new QuestionAnswer("What is 2+2?", "4");
        QuestionAnswer question2 = new QuestionAnswer("What is 3+3?", "6");

        gameStateInteractor.executeAnswerSubmit("4");
        gameStateInteractor.moveAnswerToNextQuestion(true);
        gameStateInteractor.executeAnswerSubmit("6");
        gameStateInteractor.moveAnswerToNextQuestion(true);

        assertTrue(game.isGameFinished());
    }
}
