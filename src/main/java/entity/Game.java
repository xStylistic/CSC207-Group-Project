package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy Game - No modifications to parent class.
 */
public abstract class Game {
    private final List<QuestionAnswer> questionAnswers;
    private int currentQuestionIndex;

    public Game(List<QuestionAnswer> questionAnswers) {
        this.questionAnswers = new ArrayList<>(questionAnswers);
        this.currentQuestionIndex = 0;
    }

    public QuestionAnswer getCurrentQuestion() {
        if (currentQuestionIndex < questionAnswers.size()) {
            return questionAnswers.get(currentQuestionIndex);
        }
        else {
            return null;
        }
    }

    public boolean isGameFinished() {
        return currentQuestionIndex >= questionAnswers.size();
    }
}
