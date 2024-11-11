package use_case.file;

/**
 * Exception thrown when there is an error with accessing data.
 */
public class DataAccessException extends Exception {
    public DataAccessException(String string) {
        super(string);
    }
}
