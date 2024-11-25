package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Easy Game - No modifications to parent class.
 */
public abstract class AbstractGame {
    private final List<QuestionAnswer> questionAnswers;
    private final Map<QuestionAnswer, Boolean> questionAnswersCorrect;
    private final Map<QuestionAnswer, Integer> questionAnswerTimes;
    private final int currentQuestionIndex;

    public AbstractGame(List<QuestionAnswer> questionAnswers) {
        this.questionAnswers = new ArrayList<>(questionAnswers);
        this.questionAnswersCorrect = new HashMap<>();
        this.questionAnswerTimes = new HashMap<>();
        this.currentQuestionIndex = 0;
    }

    /**
     * Gets the Current Question for the user.
     * @return the current question.
     */
    public QuestionAnswer getCurrentQuestion() {
        QuestionAnswer currentQuestion = null;
        if (currentQuestionIndex < questionAnswers.size()) {
            currentQuestion = questionAnswers.get(currentQuestionIndex);
        }
        return currentQuestion;
    }

    public boolean isGameFinished() {
        return currentQuestionIndex >= questionAnswers.size();
    }

    public Map<QuestionAnswer, Boolean> getQuestionAnswersCorrect() {
        return this.questionAnswersCorrect;
    }

    public Map<QuestionAnswer, Integer> getQuestionAnswerTimes() {
        return this.questionAnswerTimes;
    }

    /**
     * Add a keymap value for whether the question is correct.
     * @param correct if the answer satisfies the question
     */
    public void updateQuestionAnswersCorrect(boolean correct) {
        this.questionAnswersCorrect.put(questionAnswers.get(currentQuestionIndex), correct);
    }

    /**
     * Add a keymap value for whether the question is correct.
     * @param time the amount of time spent on the question
     */
    public void updateQuestionAnswerTimes(int time) {
        this.questionAnswerTimes.put(questionAnswers.get(currentQuestionIndex), time);
    }

    public QuestionTimer getTimer() {
        return null;
    }
}
