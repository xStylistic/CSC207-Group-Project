package use_case.game;

import data_access.GameDataAccessObject;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertThrows;

public class DataAccessExceptionTest {

    @Test
    public void testException() throws DataAccessException {
        try {
            GameDataAccessObject gameDataAccessObject = new GameDataAccessObject();
            File expectedFilename = new File("src/main/resources/no.txt");
            gameDataAccessObject.requestFile(expectedFilename);
        } catch (DataAccessException dataException) {
            assertThrows(DataAccessException.class, () -> {
                System.out.println("hi");
            });
        }
    }
}
