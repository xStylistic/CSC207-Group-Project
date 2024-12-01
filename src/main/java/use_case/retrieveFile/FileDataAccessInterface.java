package use_case.retrieveFile;

import java.io.File;

import entity.User;

/**
 * Interface for the GameDAO. It consists of methods for
 * accepting and loading a file.
 */
public interface FileDataAccessInterface {

    /**
     * Saves a File for a given user. This will replace any existing File.
     * <p>The password of the user must match that of the user saved in the system.</p>
     * @param user the user information associated with the File
     * @return the contents of the File
     * @throws DataAccessException if the user's File can not be saved for any reason
     */
    File requestFile(User user) throws DataAccessException;
}
