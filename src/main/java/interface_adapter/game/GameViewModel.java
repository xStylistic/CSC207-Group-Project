package interface_adapter.game;

import interface_adapter.ViewModel;

import java.io.FileNotFoundException;

/**
 * The ViewModel for the FileView.
 */
public class GameViewModel extends ViewModel<interface_adapter.game.GameState> {
    private final GameController controller;

    public GameViewModel(GameController controller) {
        super("file");
        this.controller = controller;
        setState(new interface_adapter.game.GameState());
    }
}
