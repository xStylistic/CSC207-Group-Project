package use_case.retrieveFile;

import java.io.File;
import java.util.ArrayList;

import entity.QuestionAnswer;

/**
 * The Input Boundary for our note-related use cases. Since they are closely related,
 * we have included them both in the same interface for simplicity.
 */
public interface FileInputBoundary {

    /**
     * Executes the refresh note use case.
     *
     * @return the file
     */
    File executeRetrieval();

    /**
     * Gets the File Name.
     * @return name of file
     */
    String getFileName();

    /**
     * Gets the QuestionAnswer Object.
     * @return question answer list
     */
    ArrayList<QuestionAnswer> getQuestionsAnswers();
}
