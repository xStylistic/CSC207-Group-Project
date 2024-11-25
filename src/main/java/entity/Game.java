package entity;

import java.util.ArrayList;
import java.util.List;

abstract public class Game {
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
        return null;
    }

    public void goToNextQuestion() {
        currentQuestionIndex++;
    }

    public int getSizeOfQuestionAnswers() {
        return questionAnswers.size();
    }

    public boolean isGameFinished() {
        return currentQuestionIndex >= questionAnswers.size();
    }
}
