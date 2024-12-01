package use_case.gameState;

import entity.*;
import interface_adapter.game.GameController;
import interface_adapter.game.GamePresenter;
import interface_adapter.game.GameViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.game.GameInputBoundary;
import use_case.game.GameInteractor;
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
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");
        mockQuestionsAnswers.add(question);
        QuestionAnswer question2 = new QuestionAnswer("What is 2+5?", "7");
        mockQuestionsAnswers.add(question2);

        GameStateInputBoundary interactboundary = new GameStateInteractor(mockOutputBoundary);
        GameInputBoundary inputboundary = new GameInteractor(null, null);
        GameViewModel viewmodel = new GameViewModel(new GameController(inputboundary, interactboundary));
        this.mockOutputBoundary = new GamePresenter(viewmodel);
        mockQuestionsAnswers.add(new QuestionAnswer("question1", "answer1"));
        interactor = new GameStateInteractor(mockOutputBoundary, mockQuestionsAnswers);
        interactor.setQuestionsAnswers(mockQuestionsAnswers);
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
        interactor.executeAnswerSubmit("4");
        QuestionAnswer question = interactor.getGame().getCurrentQuestion();
        assertTrue(question.validateAnswer());
    }

    @Test
    void testExecuteAnswerSubmitIncorrectAnswer() {
        interactor.startGame(0); // EasyGame
        interactor.executeAnswerSubmit("5");
        QuestionAnswer question = interactor.getGame().getCurrentQuestion();
        assertFalse(question.validateAnswer());
    }

    @Test
    void testGetScore() {
        interactor.startGame(0); // EasyGame
        AbstractGame game = interactor.getGame();
        game.updateQuestionAnswersCorrect(true);

        assertEquals(1, interactor.getScore());
    }

    @Test
    void testGetAvgTime() {
        interactor.startGame(0); // EasyGame
        AbstractGame game = interactor.getGame();
        game.updateQuestionAnswerTimes(10);

        assertEquals(10, interactor.getAvgTime());
    }

    @Test
    void testGetTotalTime() {
        interactor.startGame(0); // EasyGame
        AbstractGame game = interactor.getGame();
        game.updateQuestionAnswerTimes(10);

        assertEquals(10, interactor.getTotalTime());
    }
}
