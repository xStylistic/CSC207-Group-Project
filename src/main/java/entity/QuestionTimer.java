package entity;

import java.util.Timer;
import java.util.TimerTask;

import data_access.Constants;

/**
 * Timer to keep track of the time remaining for the current question.
 */
public class QuestionTimer {
    private final Timer timer = new Timer();
    private final int timeLimit;
    private int remainingTime;
    private final Runnable onTimeUpCallback;
    private Runnable onTickCallback;

    public QuestionTimer(int timeLimit, Runnable onTimeUpCallback, Runnable onTickCallback) {
        this.timeLimit = timeLimit;
        this.onTimeUpCallback = onTimeUpCallback;
        this.onTickCallback = onTickCallback;
        this.remainingTime = timeLimit;
    }

    /**
     * Starts our timer to start counting down.
     * @param newOnTickCallback Runnable to count
     */
    public void start(Runnable newOnTickCallback) {
        this.onTickCallback = newOnTickCallback;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (remainingTime > 0) {
                    remainingTime--;
                    newOnTickCallback.run();
                }
                else {
                    onTimeUpCallback.run();
                    stop();
                }
            }
        }, 0, Constants.THOUSAND);
    }

    /**
     * Timer to keep track of the time remaining for the current question.
     */
    public void stop() {
        timer.cancel();
    }

    public int getTimeLimit() {
        return this.timeLimit;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getRemainingTime() {
        return this.remainingTime;
    }
}
