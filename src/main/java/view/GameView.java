package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;

/**
 * The View for when the user is adding a game into the program.
 */
public class GameView extends JPanel implements ActionListener, PropertyChangeListener {
    private final GameViewModel gameViewModel;
    private final JButton chooseFileButton = new JButton("Choose File");
    private GameController gameController;

    public GameView(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.gameViewModel.addPropertyChangeListener(this);

        final JPanel buttons = new JPanel();
        buttons.add(chooseFileButton);

        chooseFileButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(chooseFileButton)) {
                        gameController.execute();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GameState state = (GameState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (state.getFile() != null) {
            JOptionPane.showMessageDialog(this, "File loaded successfully.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            SwingUtilities.getWindowAncestor(this).dispose();
        }
    }

    public void setGameController(GameController controller) {
        this.gameController = controller;
    }
}
