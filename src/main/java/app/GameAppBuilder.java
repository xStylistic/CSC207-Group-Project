package app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import interface_adapter.game.GameController;
import interface_adapter.game.GamePresenter;
import interface_adapter.game.GameViewModel;
import use_case.game.GameDataAccessInterface;
import use_case.game.GameInteractor;
import use_case.game.GameOutputBoundary;
import use_case.gameState.GameStateInteractor;
import view.GameView;

import java.io.File;

/**
 * Builder for the File Loader
 */
public class GameAppBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;
    private GameDataAccessInterface fileDAO;
    private GameViewModel gameViewModel = new GameViewModel();
    private GameView gameView;
    private GameInteractor gameInteractor;
    private GameStateInteractor gameStateInteractor;
    private File file;

    /**
     * Sets the FileDAO to be used in this application.
     * @param fileDataAccess the DAO to use
     * @return this builder
     */
    public GameAppBuilder addGameDAO(GameDataAccessInterface fileDataAccess) {
        fileDAO = fileDataAccess;
        return this;
    }

    /**
     * Creates the objects for the File Use Case and connects the GameView to its
     * controller.
     * <p>This method must be called after addGameView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addGameView
     */
    public GameAppBuilder addGameUseCase() {
        final GameOutputBoundary gameOutputBoundary = new GamePresenter(gameViewModel);
        gameInteractor = new GameInteractor(
                fileDAO, gameOutputBoundary);
        gameStateInteractor = new GameStateInteractor(
                gameOutputBoundary
        );

        final GameController controller = new GameController(gameInteractor, gameStateInteractor);
        if (gameView == null) {
            throw new RuntimeException("addFileView must be called before addFileUseCase");
        }
        gameView.setGameController(controller);
        return this;
    }

    /**
     * Creates the FileView and underlying FileViewModel.
     * @return this builder
     */
    public GameAppBuilder addGameView() {
        gameViewModel = new GameViewModel();
        gameView = new GameView(gameViewModel);
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
        frame.add(gameView);
        return frame;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
