package entity;

import java.util.Timer;
import java.util.TimerTask;

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

    public void start(Runnable onTickCallback) {
        this.onTickCallback = onTickCallback;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (remainingTime > 0) {
                    remainingTime--;
                    onTickCallback.run();
                }
                else {
                    onTimeUpCallback.run();
                    stop();
                }
            }
        }, 0, 1000);
    }

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
