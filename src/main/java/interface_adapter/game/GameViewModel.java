package interface_adapter.game;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

/**
 * The ViewModel for the FileView.
 */
public class GameViewModel extends ViewModel<interface_adapter.game.GameState> {
    public GameViewModel() {
        super(null);
        setState(new interface_adapter.game.GameState());
    }
}
