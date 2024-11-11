package interface_adapter.file;

import use_case.file.FileOutputBoundary;

import java.io.File;

/**
 * The presenter for our File viewing and editing program.
 */
public class FilePresenter implements FileOutputBoundary {

    private final FileViewModel fileViewModel;

    public FilePresenter(FileViewModel fileViewModel) {
        this.fileViewModel = fileViewModel;
    }

    /**
     * Prepares the success view for the File related Use Cases.
     *
     * @param file the output data
     */
    @Override
    public void prepareSuccessView(File file) {
        fileViewModel.getState().setFile(file);
        fileViewModel.getState().setError(null);
        fileViewModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the File related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        fileViewModel.getState().setError(errorMessage);
        fileViewModel.firePropertyChanged();
    }
}
