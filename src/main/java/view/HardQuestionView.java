package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import entity.Animal;
import entity.GameTimer;
import entity.QuestionTimer;
import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;

/**
 * View for displaying a question in hard mode.
 */
public class HardQuestionView extends JPanel implements ActionListener, PropertyChangeListener {
    private static final String HELVETICA_NEUE = "Helvetica Neue";

    private final GameViewModel gameViewModel;
    private final JButton submitAnswerButton = new JButton("Submit");
    private GameController gameController;
    private String currentQuestion;
    private JPanel entireQuestionContextPanel;
    private List<Animal> animalsToDisplay;
    private final QuestionTimer questionTimer;
    private static GameTimer gameTimer;
    private int currentQuestionIndex;
    private int totalNumQuestions;

    private javax.swing.JTextArea answerTextArea;
    private javax.swing.JLabel background;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JPanel questionPanel;
    private static javax.swing.JLabel timeElapsedLabel;
    private javax.swing.JLabel timerLabel;

    public HardQuestionView(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.gameViewModel.addPropertyChangeListener(this);
        this.currentQuestion = gameViewModel.getState().getCurrentQuestionAnswer().getQuestion();
        this.currentQuestionIndex = gameViewModel.getState().getGame().getCurrentQuestionIndex() + 1;
        this.totalNumQuestions = gameViewModel.getState().getGame().getTotalNumQuestions();

        this.entireQuestionContextPanel = new JPanel();
        this.animalsToDisplay = gameViewModel.getState().getAnimalsToDisplay();

        initComponents();

        this.questionTimer = gameViewModel.getState().getCurrentQuestionAnswer().getTimer();
        this.questionTimer.start(() -> SwingUtilities.invokeLater(() -> handleQuestionTimer()));

        gameTimer = gameViewModel.getState().getGame().getTimer();
//        gameTimer.setOnTickCallback(() -> SwingUtilities.invokeLater(() -> handleGameTimer()));
//        handleGameTimer();
    }

    public static void handleGameTimer() {
        timeElapsedLabel.setText("Time Elapsed: " + gameTimer.getSecondsElapsed());
        timeElapsedLabel.repaint();
    }

    private void handleQuestionTimer() {
        if (questionTimer.getRemainingTime() > 0) {
            timerLabel.setText("" + questionTimer.getRemainingTime());
            timerLabel.repaint();
        }
        else {
            // Submit an incorrect answer (I put it as blank assuming that the correct answer is never blank)
            gameController.submitAnswer("");
            gameController.goToNextQuestion(true);
        }
    }

    private void initComponents() {
        questionPanel = new JPanel();
        checkButton = new javax.swing.JButton();
        answerTextArea = new javax.swing.JTextArea();
        questionNumberLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        timeElapsedLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();

        setLayout(null);

        questionPanel.setBackground(new java.awt.Color(255, 244, 214));

        checkButton.setBackground(new java.awt.Color(255, 204, 102));
        checkButton.setFont(new java.awt.Font(HELVETICA_NEUE, 0, 14));
        checkButton.setText("Submit Answer");

        answerTextArea.setColumns(15);
        answerTextArea.setFont(new java.awt.Font(HELVETICA_NEUE, 0, 16));
        answerTextArea.setRows(5);

        questionNumberLabel.setFont(new java.awt.Font(HELVETICA_NEUE, 0, 14));
        questionNumberLabel.setText("Question " + currentQuestionIndex + "/" + totalNumQuestions);

        questionLabel.setFont(new java.awt.Font(HELVETICA_NEUE, 0, 16));
        questionLabel.setText(this.currentQuestion);

        timeElapsedLabel.setFont(new java.awt.Font(HELVETICA_NEUE, 0, 14));
        timeElapsedLabel.setText("Time Elapsed: ");

        // Timer Label
        timerLabel.setFont(new Font(HELVETICA_NEUE, Font.PLAIN, 16));
        timerLabel.setForeground(new Color(255, 102, 102));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setText("00");

        final javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
                questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                questionPanelLayout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(315, 315, 315))
                        .addGroup(questionPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 651,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE))
                        .addGroup(questionPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(questionNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timeElapsedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        questionPanelLayout.createSequentialGroup()
                                                .addContainerGap(51, Short.MAX_VALUE)
                                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(answerTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 657,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(52, Short.MAX_VALUE)))
        );
        questionPanelLayout.setVerticalGroup(
                questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                questionPanelLayout.createSequentialGroup()
                                        .addContainerGap(18, Short.MAX_VALUE)
                                        .addGroup(questionPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(questionNumberLabel).addComponent(timeElapsedLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13,
                                                Short.MAX_VALUE).addComponent(questionLabel)
                                        .addGap(109, 109, 109)
                                        .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        questionPanelLayout.createSequentialGroup()
                                                .addContainerGap(10, Short.MAX_VALUE)
                                                .addComponent(timerLabel)
                                                .addGap(40)
                                                .addComponent(answerTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
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

        entireQuestionContextPanel.setLayout(null);
        entireQuestionContextPanel.setBounds(0, 0, 927, 619);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png")));
        background.setBounds(0, 0, 927, 591);

        for (Animal animal : animalsToDisplay) {
            JLabel animalLabel = new JLabel();
            animalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + animal.getTypeAnimal()  + ".png")));
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
        // Similar sizing to DifficultyView
        questionPanel.setBounds(50, 90, 800, 194);

        // Add components in correct order (background first, then panel on top)
        // Question panel will be on top
        entireQuestionContextPanel.add(questionPanel);
        // Background will be behind
        entireQuestionContextPanel.add(background);

        // Move background to back
        entireQuestionContextPanel.setComponentZOrder(background, 1);
        entireQuestionContextPanel.setComponentZOrder(questionPanel, 0);

        this.add(entireQuestionContextPanel);

        // Set preferred size for the main panel
        setPreferredSize(new java.awt.Dimension(927, 619));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GameState state = (GameState) evt.getNewValue();
        final String propertyName = evt.getPropertyName();
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
                    // just submitted is true
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
