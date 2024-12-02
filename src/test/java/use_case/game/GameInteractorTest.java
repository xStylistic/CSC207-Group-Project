package use_case.game;

import data_access.GameDataAccessObject;
import entity.QuestionAnswer;
import interface_adapter.game.GameController;
import interface_adapter.game.GamePresenter;
import interface_adapter.game.GameViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.gameState.GameStateInputBoundary;
import use_case.gameState.GameStateInteractor;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameInteractorTest {
    private GameOutputBoundary mockOutputBoundary;
    private GameInteractor interactor;
    private ArrayList<QuestionAnswer> mockQuestionsAnswers;

    @Test
    public void testGetQuestionAnswer() throws DataAccessException {
        mockQuestionsAnswers = new ArrayList<>();
        QuestionAnswer question = new QuestionAnswer("What is 2+2?", "4");
        mockQuestionsAnswers.add(question);
        QuestionAnswer question2 = new QuestionAnswer("What is 2+5?", "7");
        mockQuestionsAnswers.add(question2);

        GameDataAccessObject gameDataAccessObject = new GameDataAccessObject();

        interactor = new GameInteractor(gameDataAccessObject, mockOutputBoundary);
        interactor.setQuestionsAnswers(mockQuestionsAnswers);
        assertEquals(mockQuestionsAnswers, interactor.getQuestionsAnswers());
    }
}
