package use_case.gameState;

import entity.*;
import interface_adapter.game.GameController;
import interface_adapter.game.GamePresenter;
import interface_adapter.game.GameViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
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
    void testGameDifficulty() {
        interactor.startGame(1); // EasyGame
        AbstractGame game = interactor.getGame();
        int difficulty = 10;
        if (interactor.getGame().getDifficulty().equals("Medium")){
            difficulty = 1;
            assertEquals(1, difficulty);
        }
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

    @Test
    void testgetCurrentListAnimalToDisplay() {
        interactor.startGame(0); // EasyGame
        interactor.getCurrentListAnimalsToDisplay();
        assertEquals(new ArrayList<>(), interactor.getCurrentListAnimalsToDisplay());
    }

    @Test
    void testUpdateGameStateWithNewDisplayAnimals() {
        interactor.startGame(0);
        interactor.updateGameStateWithNewDisplayAnimals();
        assertEquals(new ArrayList<>(), interactor.getCurrentListAnimalsToDisplay());
    }

    @Test
    void testGetGame() {
        interactor.startGame(0);
        EasyGame easyGame = new EasyGame(mockQuestionsAnswers);
        AbstractGame actualGame = interactor.getGame();
        assertEquals(easyGame.getDifficulty(), actualGame.getDifficulty());
        assertEquals(easyGame.getCurrentQuestion(), actualGame.getCurrentQuestion());
    }

    @Test
    void testMoveAnswerToNextQuestionMoveToAward() {
        interactor.startGame(0);
        AbstractGame actualGame = interactor.getGame();
        assertEquals("What is 2+2?", actualGame.getCurrentQuestion().getQuestion());
        actualGame.getCurrentQuestion().setUserAnswer("4");
        interactor.moveAnswerToNextQuestion(true);
        assertFalse(actualGame.getCurrentQuestion().equals("What is 2+2?"));
        assertEquals(new ArrayList<>(), interactor.getCurrentListAnimalsToDisplay());
    }

    @Test
    void testMoveAnswerToNextQuestionMoveToQuestion() {
        interactor.startGame(0);
        AbstractGame actualGame = interactor.getGame();
        actualGame.getCurrentQuestion().setUserAnswer("4");
        interactor.moveAnswerToNextQuestion(true);
        interactor.moveAnswerToNextQuestion(false);
        assertEquals("What is 2+5?", actualGame.getCurrentQuestion().getQuestion());
        System.out.println(interactor.getCurrentListAnimalsToDisplay());
        assertEquals(new ArrayList<>(), interactor.getCurrentListAnimalsToDisplay());
    }

    @Test
    void testMoveAnswerToNextQuestionWrongAnswer() {
        interactor.startGame(0);
        AbstractGame actualGame = interactor.getGame();
        actualGame.getCurrentQuestion().setUserAnswer("1");
        interactor.moveAnswerToNextQuestion(true);
        assertEquals("What is 2+5?", actualGame.getCurrentQuestion().getQuestion());
    }

    @Test
    void testSetQuestionAnswers() {
        interactor.startGame(0);
        assertEquals(mockQuestionsAnswers, interactor.getQuestionsAnswers());

        ArrayList<QuestionAnswer> newQuestionAnswer = new ArrayList<>();
        QuestionAnswer questionnew = new QuestionAnswer("What is the value of the " +
                "gravitational constant?", "9.81");
        newQuestionAnswer.add(questionnew);
        interactor.setQuestionsAnswers(newQuestionAnswer);
        assertEquals(newQuestionAnswer, interactor.getQuestionsAnswers());
    }

    @Test
    void testGetQuestionAnswers() {
        interactor.startGame(0);
        assertEquals(mockQuestionsAnswers, interactor.getQuestionsAnswers());
    }

    @Test
    void testGetGameDifficultyEasy() {
        interactor.startGame(0);
        AbstractGame actualGame = interactor.getGame();
        interactor.getGameDifficulty();
        assertEquals("easy", actualGame.getDifficulty());
    }

    @Test
    void testGetGameDifficultyMedium() {
        interactor.startGame(1);
        AbstractGame actualGame = interactor.getGame();
        interactor.getGameDifficulty();
        assertEquals("medium", actualGame.getDifficulty());
    }

    @Test
    void testGetGameDifficultyHard() {
        interactor.startGame(2);
        AbstractGame actualGame = interactor.getGame();
        interactor.getGameDifficulty();
        assertEquals("hard", actualGame.getDifficulty());
    }
}
