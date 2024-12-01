package entity;

import java.util.List;

/**
 * Medium Game implementation.
 */
public class MediumGame extends AbstractGame {
    private static final int MEDIUM_PER_QUESTION_TIME = 60;
    private GameTimer timer;
    private boolean shouldMoveOn;

    public MediumGame(List<QuestionAnswer> questionAnswers) {
        super(questionAnswers, "medium");

        for (QuestionAnswer questionAnswer : questionAnswers) {
            questionAnswer.setTimer(
                    new QuestionTimer(
                            MEDIUM_PER_QUESTION_TIME,
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

        this.timer = new GameTimer(
                MEDIUM_PER_QUESTION_TIME,
                () -> {
                    // What happens when timer is up.
                    System.out.println("Time is up");
                    forceMoveOn();
                },
                () -> {
                    System.out.println("Tick");
                    // Timer Updates here
                }
        );
    }

    public void forceMoveOn() {
        // Logic for disabling input on the current page
        getCurrentQuestion().setIsTimeUp();
    }

    public void moveToNextQuestion() {
        super.moveToNextQuestion();

        // Check here to prevent moveToNextQuestion from failing at the last step
        if (this.isGameFinished()) {
            return;
        }
        getCurrentQuestion().setTimer(
                new QuestionTimer(
                        MEDIUM_PER_QUESTION_TIME,
                        () -> {
                            System.out.println("Time is up");
                            forceMoveOn();
                        },
                        () -> System.out.println("Tick" + getCurrentQuestion().getTimer().getRemainingTime())
                )
        );
    }

    public GameTimer getTimer() {
        return timer;
    }
}
