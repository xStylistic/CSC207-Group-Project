package use_case.data_access;

import data_access.GameDataAccessObject;
import org.junit.Test;
import use_case.game.DataAccessException;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class GameDataAccessObjectTest {

    @Test
    public void testRequestFile() throws DataAccessException {
        GameDataAccessObject gameDataAccessObject = new GameDataAccessObject();
        File expectedFilename = new File("src/main/resources/test.txt");
        File actualFile = gameDataAccessObject.requestFile(expectedFilename);
        assertEquals(expectedFilename, actualFile);

    }
}
