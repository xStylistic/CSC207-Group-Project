package view;

import javax.swing.JOptionPane;

public class AnswerConfirmView {


    public boolean confirmAnswer(String question, String userAnswer, String correctAnswer) {
        int response = JOptionPane.showConfirmDialog(
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
