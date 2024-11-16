package interface_adapter.game;

import use_case.game.GameOutputBoundary;

import java.io.File;

/**
 * The presenter for our File viewing and editing program.
 */
public class GamePresenter implements GameOutputBoundary {

    private final GameViewModel gameViewModel;

    public GamePresenter(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    /**
     * Prepares the success view for the File related Use Cases.
     *
     * @param file the output data
     */
    @Override
    public void prepareSuccessView(File file) {
        gameViewModel.getState().setFile(file);
        gameViewModel.getState().setError(null);
        gameViewModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the File related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        gameViewModel.getState().setError(errorMessage);
        gameViewModel.firePropertyChanged();
    }
}
