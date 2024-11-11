package app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import use_case.file.CsvLoaderDataAccessInterface;

//import interface_adapter.note.NoteController;
//import interface_adapter.note.NotePresenter;
//import interface_adapter.note.NoteViewModel;
//import use_case.csvloader.NoteInteractor;
//import use_case.note.NoteOutputBoundary;
//import view.NoteView;

/**
 * Builder for the CSV Loader
 */
public class CSVLoaderAppBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;
    private CsvLoaderDataAccessInterface csvLoaderDAO;
//    private NoteViewModel noteViewModel = new NoteViewModel();
//    private NoteView noteView;
//    private NoteInteractor noteInteractor;

    /**
     * Sets the NoteDAO to be used in this application.
     * @param csvLoaderDataAccess the DAO to use
     * @return this builder
     */
    public CSVLoaderAppBuilder addNoteDAO(CsvLoaderDataAccessInterface csvLoaderDataAccess) {
        csvLoaderDAO = csvLoaderDataAccess;
        return this;
    }

    /**
     * Creates the objects for the Note Use Case and connects the NoteView to its
     * controller.
     * <p>This method must be called after addNoteView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addNoteView
     */
    public CSVLoaderAppBuilder addCsvLoaderUseCase() {
        final NoteOutputBoundary noteOutputBoundary = new NotePresenter(noteViewModel);
        noteInteractor = new NoteInteractor(
                noteDAO, noteOutputBoundary);

        final NoteController controller = new NoteController(noteInteractor);
        if (noteView == null) {
            throw new RuntimeException("addNoteView must be called before addNoteUseCase");
        }
        noteView.setNoteController(controller);
        return this;
    }

    /**
     * Creates the NoteView and underlying NoteViewModel.
     * @return this builder
     */
    public NoteAppBuilder addNoteView() {
        noteViewModel = new NoteViewModel();
        noteView = new NoteView(noteViewModel);
        return this;
    }

    /**
     * Builds the application.
     * @return the JFrame for the application
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("CSV Loader Application");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(noteView);

        // refresh so that the note will be visible when we start the program
        noteInteractor.executeRefresh();

        return frame;

    }
}
