package view;

import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is adding a game into the program
 */
public class GameView extends JPanel implements ActionListener, PropertyChangeListener {
    private final GameViewModel gameViewModel;
    private final JButton chooseFileButton = new JButton("Choose File");
    private final JButton startGameButton = new JButton("Start Game");
    private GameController gameController;
    private JLabel background;

    public GameView(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.gameViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(927, 591));

        background = new JLabel(new ImageIcon(getClass().getResource("/farm.png")));
        background.setBounds(0, 0, 927, 591);

        JPanel mainPanel = new JPanel(null);
        mainPanel.setOpaque(false);

        chooseFileButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        chooseFileButton.setBounds(314, 200, 300, 50);

        startGameButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        startGameButton.setBounds(314, 300, 300, 50);
        startGameButton.setEnabled(false);

        chooseFileButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(chooseFileButton)) {
                        gameController.execute();
                        String name = gameController.getFileName();

                        JLabel fileLabel = new JLabel(name);
                        fileLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));

                        int fileLabelY = chooseFileButton.getY()
                                + (startGameButton.getY() - chooseFileButton.getY()) / 2 - 15;
                        fileLabel.setBounds(318, fileLabelY, 300, 50);

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
                        if (startGameButton.isEnabled()) {
                            gameController.setDifficulty();
                        }
                    }
                }
        );

        // Add components to main panel
        mainPanel.setBounds(0, 0, 927, 619);
        mainPanel.add(chooseFileButton);
        mainPanel.add(startGameButton);

        // Add main panel to background
        add(mainPanel);
        add(background);

        setComponentZOrder(background, 1);
        setComponentZOrder(mainPanel, 0);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GameState state = (GameState) evt.getNewValue();
        String propertyChanged = evt.getPropertyName();
        if (gameViewModel.getViewName().equals("file")) {
            if (state.getError() != null) {
                JOptionPane.showMessageDialog(this, state.getError(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setGameController(GameController controller) {
        this.gameController = controller;
    }
}