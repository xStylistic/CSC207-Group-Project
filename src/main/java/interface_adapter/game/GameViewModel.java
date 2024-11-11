package interface_adapter.game;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the FileView.
 */
public class GameViewModel extends ViewModel<GameState> {
    public GameViewModel() {
        super(null);
        setState(new GameState());
    }
}
