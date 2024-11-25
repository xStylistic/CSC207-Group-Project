package view;

import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuestionAnswerView extends JPanel implements ActionListener, PropertyChangeListener {
    private final GameViewModel gameViewModel;
    private final JButton submitAnswerButton = new JButton("Submit");
    private GameController gameController;

    private JLabel questionLabel;
    private JTextField answerField;
    private JLabel timerLabel;

    public QuestionAnswerView(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.gameViewModel.addPropertyChangeListener(this);
        String currentQuestion = gameViewModel.getState().getCurrentQuestionAnswer().getQuestion();

        questionLabel = new JLabel("Question " + currentQuestion + " ?");
        timerLabel = new JLabel("Time: 30");
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        answerField = new JTextField();

        final JPanel buttons = new JPanel();
        buttons.add(submitAnswerButton);

        submitAnswerButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(submitAnswerButton)) {
                        gameController.submitAnswer(answerField.getText());
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(questionLabel);
        this.add(answerField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        // call game controller with some answer variable -> tell game state interactor -> game presenter to change some vairables to fire property cahnged
            // we can either catch those property changed here or just switch to new view
            // which would probably be an answer view
            // Q -> A -> Animal shits if correct -> Q -> A -> animal shits if correct
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GameState state = (GameState) evt.getNewValue();
        String propertyName = evt.getPropertyName();
        switch (propertyName) {
            case "message": // Update the results and the button
                revealCorrectOrIncorrect(state);
                // Update the button to go to the next stage
                this.remove(submitAnswerButton);
                this.add(createButtonThatGoesToTheNextState());
                this.repaint();
                this.revalidate();
                break;
            default:
                break;
        }
    }

    private JButton createButtonThatGoesToTheNextState(GameState state) {
        // TODO: Return JButton with actionlistener attached that goes to the next

        // Go to the next state

        return new JButton("Go to next state");
    }

    private void revealCorrectOrIncorrect(GameState state) {
        // Sets the textfield to the message i the game state
        this.answerField.setText(state.getMessage());
        System.out.println(state.getMessage());
    }

    public void setQuestionController(GameController controller) {
        this.gameController = controller;
    }
}
