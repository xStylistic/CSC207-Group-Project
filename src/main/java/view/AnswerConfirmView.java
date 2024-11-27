package view;

import javax.swing.JOptionPane;

/**
 * The view for confirming answer.
 */
public class AnswerConfirmView {

    /**
     * Overrides an incorrect answer.
     * @param question the question.
     * @param userAnswer the user's input.
     * @param correctAnswer the correct answer.
     * @return True, if answer is correct. Otherwise, false.
     */
    public boolean confirmAnswer(String question, String userAnswer, String correctAnswer) {
        final int response = JOptionPane.showConfirmDialog(
                null,
                "For this question, (" + question + ") \n you answered: \"" + userAnswer + "\"\n"
                        + "The actual answer is: \"" + correctAnswer + "\"\n"
                        + "Would you like to accept yours as the correct answer?",
                userAnswer,
                JOptionPane.YES_NO_OPTION
        );
        return response == JOptionPane.YES_OPTION;
    }
}
