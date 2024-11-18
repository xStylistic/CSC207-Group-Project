package view;

import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;
import interface_adapter.question.QuestionController;
import interface_adapter.question.QuestionState;
import interface_adapter.question.QuestionViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuestionAnswerView extends JPanel implements ActionListener, PropertyChangeListener {
    private final QuestionViewModel questionViewModel;
    private final JButton submitAnswerButton = new JButton("Submit");
    private QuestionController questionController;

    private JLabel questionLabel;
    private JTextField answerField;
    private JLabel timerLabel;

    public QuestionAnswerView(QuestionViewModel questionViewModel) {
        this.questionViewModel = questionViewModel;
        this.questionViewModel.addPropertyChangeListener(this);

        questionLabel = new JLabel("Question ... ... ?");
        timerLabel = new JLabel("Time: 30");
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        answerField = new JTextField();

        final JPanel buttons = new JPanel();
        buttons.add(submitAnswerButton);

        submitAnswerButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(submitAnswerButton)) {
                        questionController.execute(answerField.getText());
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
        final QuestionState state = (QuestionState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setQuestionController(QuestionController controller) {
        this.questionController = controller;
    }
}
