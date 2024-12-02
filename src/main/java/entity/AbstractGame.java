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
    private GameTimer timer;
    private final String difficulty;

    public AbstractGame(List<QuestionAnswer> questionAnswers, String difficulty) {
        this.questionAnswers = new ArrayList<>(questionAnswers);
        this.questionAnswersCorrect = new HashMap<>();
        this.questionAnswerTimes = new HashMap<>();
        this.currentQuestionIndex = 0;
        final String[] animals = {
            "pig",
            "alpaca",
            "horse",
            "cow",
            "chicken",
            "fox",
            "bear",
            "tiger",
            "flamingo",
            "rabbit",
        };
        this.animalFarm = new AnimalFarm(animals);
        this.timer = new GameTimer(
                () -> { },
                () -> System.out.println("Elapsed: " + this.timer.getSecondsElapsed() + " seconds.")
        );
        this.difficulty = difficulty;
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
     * Gets the number of correctly answered questions.
     * @return the number of correct answers.
     */
    public int getScore() {
        int correct = 0;
        for (Boolean value : this.questionAnswersCorrect.values()) {
            if (Boolean.TRUE.equals(value)) {
                correct++;
            }
        }
        return correct;
    }

    /**
     * Gets the total amount of time of a game.
     * @return the total amount of time
     */
    public int getTotalTime() {
        int totalTime = 0;
        for (Integer time : this.questionAnswerTimes.values()) {
            totalTime += time;
        }
        return totalTime;
    }

    public int getAvgTime() {
        return this.getTotalTime() / this.getQuestionAnswerTimes().size();
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
            switch (difficulty) {
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

    public Integer getCurrentQuestionAnswerTime() {
        return this.questionAnswerTimes.get(questionAnswers.get(currentQuestionIndex));
    }

    /**
     * Add a keymap value for whether the question is correct.
     * @param time the amount of time spent on the question
     */
    public void updateQuestionAnswerTimes(int time) {
        this.questionAnswerTimes.put(questionAnswers.get(currentQuestionIndex), time);
    }

    /**
     * Increments the correct question index.
     */
    public void moveToNextQuestion() {
        this.currentQuestionIndex++;
    }

    public AnimalFarm getAnimalFarm() {
        return animalFarm;
    }

    public GameTimer getTimer() {
        return this.timer;
    }

    public int getCurrentQuestionIndex() {
        return this.currentQuestionIndex;
    }

    public int getTotalNumQuestions() {
        return this.questionAnswers.size();
    }

    public void setTimer(GameTimer timer) {
        this.timer = timer;
    }

    public String getDifficulty() {
        return this.difficulty;
    }
}
