package interface_adapter.file;

import use_case.file.FileInputBoundary;

import java.io.File;

/**
 * Controller for our File related Use Cases.
 */
public class FileController {

    private final FileInputBoundary fileInteractor;

    public FileController(FileInputBoundary fileInteractor) {
        this.fileInteractor = fileInteractor;
    }

    /**
     * Executes the File related Use Cases.
     */
    public File execute() {
        return fileInteractor.executeRetrieval();
    }
}
