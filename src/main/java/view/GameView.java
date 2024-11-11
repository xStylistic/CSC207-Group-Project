package view;

import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * The View for when the user is adding a game into the program
 */
public class GameView extends JPanel implements ActionListener, PropertyChangeListener {

    private final GameViewModel fileViewModel;
    private final JButton chooseFileButton = new JButton("Choose File");
    private final JButton startGameButton = new JButton("Start Game");
    private GameController fileController;


    public GameView(GameViewModel fileViewModel) {
        this.fileViewModel = fileViewModel;
        this.fileViewModel.addPropertyChangeListener(this);

        final JPanel mainPanel = new JPanel();
        mainPanel.add(chooseFileButton);
        mainPanel.add(startGameButton);
        startGameButton.setEnabled(false);

        chooseFileButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(chooseFileButton)) {
                        fileController.execute();
                        String name = fileController.getFileName();
                        JLabel fileLabel = new JLabel(name);
                        fileLabel.setVisible(true);
                        mainPanel.add(fileLabel);
                        startGameButton.setEnabled(true);

                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                }
        );

        startGameButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(startGameButton)) {
                        if (startGameButton.isEnabled())
                        {
                            // Go to the Actual Game page
                            mainPanel.remove(chooseFileButton);
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(mainPanel);
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
        } else if (state.getFile() != null) {
            JOptionPane.showMessageDialog(this, "File loaded successfully.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
//            SwingUtilities.getWindowAncestor(this).dispose();
        }
    }

    public void setGameController(GameController controller) {
        this.fileController = controller;
    }

}

