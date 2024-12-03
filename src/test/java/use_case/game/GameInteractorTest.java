package use_case.game;

import data_access.GameDataAccessObject;
import entity.QuestionAnswer;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

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

    @Test
    public void testExecuteRetrieval() throws DataAccessException, IOException {
        GameDataAccessInterface mockDataAccess = mock(GameDataAccessInterface.class);
        GameOutputBoundary outputBound = mock(GameOutputBoundary.class);

        File tempFile = File.createTempFile("testFile", ".txt");
        tempFile.deleteOnExit();
        List<String> fileContent = List.of(
                "Header line",
                "Question1\tAnswer1",
                "Question2\tAnswer2"
        );
        Files.write(tempFile.toPath(), fileContent);

        interactor = new GameInteractor(mockDataAccess, outputBound);
        when(mockDataAccess.requestFile()).thenReturn(tempFile);
        File result = interactor.executeRetrieval();

        assertEquals(tempFile, result);
    }

    @Test
    public void testGetFileName() throws DataAccessException, IOException {
        GameDataAccessInterface mockDataAccess = mock(GameDataAccessInterface.class);
        GameOutputBoundary outputBound = mock(GameOutputBoundary.class);

        File tempFile = File.createTempFile("testFile", ".txt");
        tempFile.deleteOnExit();
        List<String> fileContent = List.of(
                "Header line",
                "Question1\tAnswer1",
                "Question2\tAnswer2"
        );
        Files.write(tempFile.toPath(), fileContent);

        interactor = new GameInteractor(mockDataAccess, outputBound);
        when(mockDataAccess.requestFile()).thenReturn(tempFile);
        File result = interactor.executeRetrieval();

        assertEquals("testFile", interactor.getFileName().substring(0,8));
    }
}
