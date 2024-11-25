package entity;

import java.util.List;

/**
 * Medium Game implementation.
 */
public class HardGame extends AbstractGame {
    private static final int HARD_PER_QUESTION_TIME = 180;
    private QuestionTimer timer;
    private boolean shouldMoveOn;

    public HardGame(List<QuestionAnswer> questionAnswers) {
        super(questionAnswers, "medium");

        this.timer = new QuestionTimer(
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
        );
    }

    public void forceMoveOn() {
        // Logic for disabling input on the current page
        shouldMoveOn = true;
    }

    public boolean getShouldMoveOn() {
        return shouldMoveOn;
    }

    public QuestionTimer getTimer() {
        return timer;
    }
}
