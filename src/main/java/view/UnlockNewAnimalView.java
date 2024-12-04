package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import entity.Animal;
import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;

/**
 * This happens every time difficulty correct.
 */
public class UnlockNewAnimalView extends JPanel implements ActionListener, PropertyChangeListener {
    private final GameViewModel gameViewModel;
    private GameController gameController;
    private List<Animal> animalsToDisplay;
    private JLabel animal;
    private JLabel animalLabel;
    private JTextArea funFactLabel;
    private JLabel titleLabel;
    private JButton nextButton;

    public UnlockNewAnimalView(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.gameViewModel.addPropertyChangeListener(this);
        this.animalsToDisplay = gameViewModel.getState().getAnimalsToDisplay();

        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(927, 619));

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/farm.png")));
        background.setBounds(0, 0, 927, 591);

        JPanel newAnimalPanel = new JPanel(new GridBagLayout());
        newAnimalPanel.setBackground(new Color(255, 204, 102));
        newAnimalPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 183, 102), 2));

        // Centre the panel
        int panelWidth = 500;
        int panelHeight = 360;
        int x = (927 - panelWidth) / 2;
        int y = (591 - panelHeight) / 2;
        newAnimalPanel.setBounds(x, y, panelWidth, panelHeight);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        titleLabel = new JLabel("You unlocked a new animal!");
        titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newAnimalPanel.add(titleLabel, gbc);

        // Animal image
        gbc.gridy++;
        animal = new JLabel();
        if (animalsToDisplay.size() >= 1) {
            animal.setIcon(new ImageIcon(getClass().getResource(
                    "/" + animalsToDisplay.get(animalsToDisplay.size() - 1).getTypeAnimal() + ".png")));
        } else {
            animal.setText("No Animal Image");
        }
        animal.setHorizontalAlignment(SwingConstants.CENTER);
        newAnimalPanel.add(animal, gbc);

        // Animal name label
        gbc.gridy++;
        animalLabel = new JLabel();
        if (animalsToDisplay.size() >= 1) {
            animalLabel.setText("Animal Name: " + animalsToDisplay.get(animalsToDisplay.size() - 1).getName());
        } else {
            animalLabel.setText("Animal Name: N/A");
        }
        animalLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        animalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        newAnimalPanel.add(animalLabel, gbc);

        // Fun fact label
        gbc.gridy++;
        funFactLabel = new JTextArea();
        funFactLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        funFactLabel.setLineWrap(true);
        funFactLabel.setWrapStyleWord(true);
        funFactLabel.setOpaque(false);
        funFactLabel.setEditable(false);
        funFactLabel.setBackground(new Color(255, 238, 173));
        funFactLabel.setText(animalsToDisplay.size() >= 1
                ? "Fun Fact: " + animalsToDisplay.get(animalsToDisplay.size() - 1).getFact()
                : "Fun Fact: N/A");
        funFactLabel.setBorder(null);
        funFactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        funFactLabel.setPreferredSize(new Dimension(225, 60));
        funFactLabel.setMaximumSize(new Dimension(225, 60));
        newAnimalPanel.add(funFactLabel, gbc);

        // Next button
        gbc.gridy++;
        nextButton = new JButton("Nice");
        nextButton.setBackground(new Color(255, 238, 173));
        nextButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        nextButton.addActionListener(evt -> {
            if (evt.getSource().equals(nextButton)) {
                gameController.goToNextQuestion(false);
            }
        });
        newAnimalPanel.add(nextButton, gbc);

        // Add components to the main panel
        add(newAnimalPanel);
        add(background);
        setComponentZOrder(newAnimalPanel, 0);
        setComponentZOrder(background, 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("displayAnimals".equals(evt.getPropertyName())) {
            final GameState state = (GameState) evt.getNewValue();
            this.animalsToDisplay = state.getAnimalsToDisplay();
        }
    }

    public void setQuestionController(GameController controller) {
        this.gameController = controller;
    }
}