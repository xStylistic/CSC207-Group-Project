package entity;

import java.util.List;

/**
 * Medium Game implementation.
 */
public class HardGame extends AbstractGame {
    private static final int HARD_PER_QUESTION_TIME = 30;
    private GameTimer timer;
    private boolean shouldMoveOn;

    public HardGame(List<QuestionAnswer> questionAnswers) {
        super(questionAnswers, "hard");

        for (QuestionAnswer questionAnswer : questionAnswers) {
            questionAnswer.setTimer(
                    new QuestionTimer(
                            HARD_PER_QUESTION_TIME,
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
        if (!this.isGameFinished()) {
            getCurrentQuestion().setTimer(
                    new QuestionTimer(
                            HARD_PER_QUESTION_TIME,
                            () -> {
                                System.out.println("Time is up");
                                forceMoveOn();
                            },
                            () -> System.out.println("Tick: " + getCurrentQuestion().getTimer().getRemainingTime())
                    )
            );
        }
    }

    public boolean getShouldMoveOn() {
        return shouldMoveOn;
    }
}
