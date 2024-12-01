package use_case.game;

import java.io.File;

/**
 * Interface for the GameDAO. It consists of methods for
 * accepting and loading a file.
 */
public interface GameDataAccessInterface {

    /**
     * Saves a File for a given user. This will replace any existing File.
     * <p>The password of the user must match that of the user saved in the system.</p>
     * @return the contents of the File
     * @throws DataAccessException if the user's File can not be saved for any reason
     */
    File requestFile() throws DataAccessException;
}
