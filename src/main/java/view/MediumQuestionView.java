package view;

import entity.Animal;
import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 *
 * @author bonnychen
 */
public class MediumQuestionView extends JPanel implements ActionListener, PropertyChangeListener {
    private final GameViewModel gameViewModel;
    private final JButton submitAnswerButton = new JButton("Submit");
    private GameController gameController;
    private String currentQuestion;
    private JPanel entireQuestionContextPanel;
    private List<Animal> animalsToDisplay;
    // TODO: CONNECT TIMER LOGIC SASS

    public MediumQuestionView(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.gameViewModel.addPropertyChangeListener(this);
        this.currentQuestion = gameViewModel.getState().getCurrentQuestionAnswer().getQuestion();
        this.entireQuestionContextPanel = new JPanel();
        this.animalsToDisplay = gameViewModel.getState().getAnimalsToDisplay();

        initComponents();
    }

    private void initComponents() {

        questionPanel = new JPanel();
        checkButton = new javax.swing.JButton();
        answerTextArea = new javax.swing.JTextArea();
        questionNumberLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        timeElapsedLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();


        setLayout(null);

        questionPanel.setBackground(new java.awt.Color(255, 244, 214));

        checkButton.setBackground(new java.awt.Color(255, 204, 102));
        checkButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        checkButton.setText("Submit Answer");

        answerTextArea.setColumns(15);
        answerTextArea.setFont(new java.awt.Font("Helvetica Neue", 0, 16));
        answerTextArea.setRows(5);

        questionNumberLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        questionNumberLabel.setText("Question -/-");

        questionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16));
        questionLabel.setText("Question: " + this.currentQuestion);

        timeElapsedLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        timeElapsedLabel.setText("Time Elapsed: "); // TODO: SASWATA

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
                questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(315, 315, 315))
                        .addGroup(questionPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE))
                        .addGroup(questionPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(questionNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timeElapsedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                                        .addContainerGap(51, Short.MAX_VALUE)
                                        .addComponent(answerTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(52, Short.MAX_VALUE)))
        );
        questionPanelLayout.setVerticalGroup(
                questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(questionNumberLabel)
                                        .addComponent(timeElapsedLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(questionLabel)
                                .addGap(109, 109, 109)
                                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                                        .addContainerGap(79, Short.MAX_VALUE)
                                        .addComponent(answerTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(63, Short.MAX_VALUE)))
        );


        checkButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(checkButton)) {
                        gameController.submitAnswer(answerTextArea.getText());
                    }
                }
        );

        this.setLayout(null);

        // Set layout for entireQuestionContextPanel
        entireQuestionContextPanel.setLayout(null);
        entireQuestionContextPanel.setBounds(0, 0, 927, 591);  // Set size to match background

        // Setup background
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png")));
        background.setBounds(0, 0, 927, 591);

        for (Animal animal : animalsToDisplay) {
            JLabel animalLabel = new JLabel();
            animalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + animal.getName() + ".png")));
            animalLabel.setBounds(
                    (int) animal.getxCoordinate(),
                    (int) animal.getyCoordinate(),
                    100,
                    100
            );
            background.add(animalLabel);
        }
        background.revalidate();
        background.repaint();

        // Setup questionPanel bounds - centered and smaller than background
        questionPanel.setBounds(50, 90, 800, 194);  // Similar sizing to DifficultyView

        // Add components in correct order (background first, then panel on top)
        entireQuestionContextPanel.add(questionPanel);   // Question panel will be on top
        entireQuestionContextPanel.add(background);      // Background will be behind

        // Move background to back
        entireQuestionContextPanel.setComponentZOrder(background, 1);
        entireQuestionContextPanel.setComponentZOrder(questionPanel, 0);

        this.add(entireQuestionContextPanel);

        // Set preferred size for the main panel
        setPreferredSize(new java.awt.Dimension(927, 591));
    }

    private javax.swing.JTextArea answerTextArea;
    private javax.swing.JLabel background;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JLabel timeElapsedLabel;


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GameState state = (GameState) evt.getNewValue();
        String propertyName = evt.getPropertyName();
        switch (propertyName) {
            case "message":
                revealCorrectOrIncorrect(state);

                // Update existing button
                checkButton.setText("Next Question");
                // Remove old action listeners
                for (ActionListener al : checkButton.getActionListeners()) {
                    checkButton.removeActionListener(al);
                }
                // Add new action listener
                checkButton.addActionListener(evt2 -> {
                    // just submitted should be true
                    gameController.goToNextQuestion(true);
                });

                questionPanel.revalidate();
                questionPanel.repaint();
                break;
            default:
                break;
        }
    }

    private void revealCorrectOrIncorrect(GameState state) {
        // Sets the textfield to the message i the game state
        this.answerTextArea.setText(state.getMessage());
        System.out.println(state.getMessage());
    }

    public void setQuestionController(GameController controller) {
        this.gameController = controller;
    }
}
