package use_case.gameState;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.game.GameOutputBoundary;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameStateInteractorTest {
    private GameOutputBoundary mockOutputBoundary;
    private GameStateInteractor interactor;
    private ArrayList<QuestionAnswer> mockQuestionsAnswers;

    @BeforeEach
    void setUp() {
        mockQuestionsAnswers = new ArrayList<>();
        interactor = new GameStateInteractor(mockOutputBoundary, mockQuestionsAnswers);
    }

    @Test
    void testStartGameWithValidDifficulty() {
        interactor.startGame(0); // EasyGame
        assertEquals(EasyGame.class, interactor.getGame().getClass());

        interactor.startGame(1); // MediumGame
        assertEquals(MediumGame.class, interactor.getGame().getClass());

        interactor.startGame(2); // HardGame
        assertEquals(HardGame.class, interactor.getGame().getClass());
    }

    @Test
    void testStartGameWithInvalidDifficulty() {
        interactor.startGame(3); // Invalid difficulty
        assertNull(interactor.getGame());
    }

    @Test
    void testExecuteAnswerSubmitCorrectAnswer() {
        interactor.startGame(0); // EasyGame
        AbstractGame game = interactor.getGame();
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");

        interactor.executeAnswerSubmit("4");

        assertTrue(question.isCorrect());
    }

    @Test
    void testExecuteAnswerSubmitIncorrectAnswer() {
        interactor.startGame(0); // EasyGame
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");
        interactor.executeAnswerSubmit("5");

        assertFalse(question.isCorrect());
    }

    @Test
    void testGetScore() {
        interactor.startGame(0); // EasyGame
        AbstractGame game = interactor.getGame();
        game.updateQuestionAnswersCorrect(true);
        game.updateQuestionAnswersCorrect(true);

        assertEquals(2, interactor.getScore());
    }

    @Test
    void testGetAvgTime() {
        interactor.startGame(0); // EasyGame
        AbstractGame game = interactor.getGame();
        game.updateQuestionAnswerTimes(10);
        game.updateQuestionAnswerTimes(20);

        assertEquals(15, interactor.getAvgTime());
    }

    @Test
    void testGetTotalTime() {
        interactor.startGame(0); // EasyGame
        AbstractGame game = interactor.getGame();
        game.updateQuestionAnswerTimes(10);
        game.updateQuestionAnswerTimes(20);

        assertEquals(30, interactor.getTotalTime());
    }
}
