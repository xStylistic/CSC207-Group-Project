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
    private final String difficulty;

    public AbstractGame(List<QuestionAnswer> questionAnswers, String difficulty) {
        this.questionAnswers = new ArrayList<>(questionAnswers);
        this.questionAnswersCorrect = new HashMap<>();
        this.questionAnswerTimes = new HashMap<>();
        this.currentQuestionIndex = 0;
        final String[] animals = {
                "Sumatran Tiger",
                "Indochinese Tiger",
                "Rabbit",
                "Asiatic Black Bear",
                "American Foxhound",
                "Alpaca",
                "Cross Fox",
                "Bear",
                "Giant Panda Bear",
                "Smooth Fox Terrier",
                "Tiger",
                "Tennessee Walker Horse",
                "Fox Terrier",
                "Wire Fox Terrier",
                "Siberian Tiger",
                "Fennec Fox",
                "Polar Bear",
                "Toy Fox Terrier",
                "Horse",
                "Kit Fox",
                "Malayan Tiger",
                "Sun Bear",
                "North American Black Bear",
                "Jackrabbit",
                "Arctic Fox",
                "White Tiger",
                "Saber-Toothed Tiger",
                "Silkie Chicken",
                "Red Fox",
                "Cow",
                "Gray Fox",
                "Fox",
                "Pig",
                "Grizzly Bear",
                "Tibetan Fox",
                "Spectacled Bear",
                "English Foxhound",
                "Marble Fox",
                "Canadian Horse",
                "Flamingo",
                "Darwin's fox",
                "Brown Bear",
                "South China Tiger",
                "Chicken",
                "Bengal Tiger"
        };
        this.animalFarm = new AnimalFarm(animals);
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
            int count = 1;
            switch (difficulty) {
                case "medium":
                    count = 2;
                    break;
                case "hard":
                    count = Integer.MAX_VALUE;
                    break;
                default:
                    count = 1;
                    break;
            }
            this.animalFarm.removeAnimal(count);
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
