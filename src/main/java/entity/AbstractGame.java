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
    private int currentQuestionIndex;
    private final AnimalFarm animalFarm;
    private final String gDifficulty;

    public AbstractGame(List<QuestionAnswer> questionAnswers, String difficulty) {
        this.questionAnswers = new ArrayList<>(questionAnswers);
        this.questionAnswersCorrect = new HashMap<>();
        this.questionAnswerTimes = new HashMap<>();
        this.currentQuestionIndex = 0;
        final String[] animals = {
                "pig",
                "alpaca",
//                "horse",
                "cow",
                "chicken",
                "fox",
                "bear",
                "tiger",
                "flamingo",
                "rabbit",
        };
        this.animalFarm = new AnimalFarm(animals);
        this.gDifficulty = difficulty;
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

    public int getNumberCorrect() {
        int correct = 0;
        for (Boolean value : this.questionAnswersCorrect.values()) {
            if (Boolean.TRUE.equals(value)) {
                correct++;
            }
        }
        return correct;
    }

    public int getNumberAnswered() {
        return this.questionAnswersCorrect.size();
    }

    /**
     * Add a keymap value for whether the question is correct.
     * @param correct if the answer satisfies the question
     */
    public void updateQuestionAnswersCorrect(boolean correct) {
        this.questionAnswersCorrect.put(questionAnswers.get(currentQuestionIndex), correct);
        if (correct) {
            this.animalFarm.addAnimal();
        }
        else {
            switch (gDifficulty) {
                case "medium":
                    this.animalFarm.removeAnimal(2);
                    break;
                case "hard":
                    this.animalFarm.removeAnimal(Integer.MAX_VALUE);
                    break;
                default:
                    this.animalFarm.removeAnimal(1);
                    break;
            }
        }
    }

    /**
     * Add a keymap value for whether the question is correct.
     * @param time the amount of time spent on the question
     */
    public void updateQuestionAnswerTimes(int time) {
        this.questionAnswerTimes.put(questionAnswers.get(currentQuestionIndex), time);
    }

    /**
     * Increments the currect question index.
     */
    public void moveToNextQuestion() {
        this.currentQuestionIndex++;
    }


    public AnimalFarm getAnimalFarm() {
        return animalFarm;
    }

    public QuestionTimer getTimer() {
        return null;
    }
}
