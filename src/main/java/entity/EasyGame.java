package entity;

import java.util.List;

/**
 * Easy Game - No modifications to parent class.
 */
public class EasyGame extends AbstractGame {
    private static final int EASY_QUESTION_TIME = 99999999;

    public EasyGame(List<QuestionAnswer> questionAnswers) {
        super(questionAnswers, "easy");

        for (QuestionAnswer questionAnswer : questionAnswers) {
            questionAnswer.setTimer(
                    new QuestionTimer(
                            EASY_QUESTION_TIME,
                            () -> {
                                // What happens when timer is up.
                                System.out.println("Time is up");
                                forceMoveOn();
                            },
                            () -> {
                                // What happens every second
                                System.out.println("Tick");
                                // Timer Updates here
                            }
                    )
            );
        }
    }

    /**
     * Force moving on to next question when timer is up.
     */
    public void forceMoveOn() {
        // Logic for disabling input on the current page
        getCurrentQuestion().setIsTimeUp();
    }

    /**
     * Move to next question after answer submission.
     */
    public void moveToNextQuestion() {
        super.moveToNextQuestion();

        // Check here to prevent moveToNextQuestion from failing at the last step
        if (this.isGameFinished()) {
            return;
        }
        getCurrentQuestion().setTimer(
                new QuestionTimer(
                        EASY_QUESTION_TIME,
                        () -> {
                            System.out.println("Time is up");
                            forceMoveOn();
                        },
                        () -> System.out.println("Tick" + getCurrentQuestion().getTimer().getRemainingTime())
                )
        );
    }
}
