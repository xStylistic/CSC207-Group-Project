package entity;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private final Timer timer = new Timer();
    private int secondsElapsed;
    private final Runnable onTimeUpCallback;
    private Runnable onTickCallback;
    private boolean isRunning = false;

    public GameTimer(Runnable onTimeUpCallback, Runnable onTickCallback) {
        this.secondsElapsed = 0;
        this.onTimeUpCallback = onTimeUpCallback;
        this.onTickCallback = onTickCallback;
    }

    public void start(Runnable onTickCallback) {
        this.onTickCallback = onTickCallback;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondsElapsed++;
                if (onTickCallback != null) {
                    onTickCallback.run();
                }
            }
        }, 0, 1000);
    }

    public void stop() {
        timer.cancel();
        isRunning = false;
    }

    public int getSecondsElapsed() {
        return secondsElapsed;
    }

    public void setOnTickCallback(Runnable onTickCallback) {
        this.onTickCallback = onTickCallback;
        if (onTickCallback != null) {
            onTickCallback.run();
        }
    }
}
