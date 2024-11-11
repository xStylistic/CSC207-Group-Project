package app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import interface_adapter.file.FileController;
import interface_adapter.file.FilePresenter;
import interface_adapter.file.FileViewModel;
import use_case.file.FileDataAccessInterface;
import use_case.file.FileInteractor;
import use_case.file.FileOutputBoundary;
import view.FileView;

import java.io.File;

/**
 * Builder for the File Loader
 */
public class FileLoaderAppBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;
    private FileDataAccessInterface fileDAO;
    private FileViewModel fileViewModel = new FileViewModel();
    private FileView fileView;
    private FileInteractor fileInteractor;
    private File file;

    /**
     * Sets the FileDAO to be used in this application.
     * @param fileDataAccess the DAO to use
     * @return this builder
     */
    public FileLoaderAppBuilder addFileDAO(FileDataAccessInterface fileDataAccess) {
        fileDAO = fileDataAccess;
        return this;
    }

    /**
     * Creates the objects for the File Use Case and connects the FileView to its
     * controller.
     * <p>This method must be called after addFileView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFileView
     */
    public FileLoaderAppBuilder addFileUseCase() {
        final FileOutputBoundary fileOutputBoundary = new FilePresenter(fileViewModel);
        fileInteractor = new FileInteractor(
                fileDAO, fileOutputBoundary);

        final FileController controller = new FileController(fileInteractor);
        if (fileView == null) {
            throw new RuntimeException("addFileView must be called before addFileUseCase");
        }
        fileView.setFileController(controller);
        return this;
    }

    /**
     * Creates the FileView and underlying FileViewModel.
     * @return this builder
     */
    public FileLoaderAppBuilder addFileView() {
        fileViewModel = new FileViewModel();
        fileView = new FileView(fileViewModel);
        return this;
    }

    /**
     * Builds the application.
     * @return the JFrame for the application
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("File Application");
        frame.setSize(WIDTH, HEIGHT);
        frame.add(fileView);
        return frame;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
