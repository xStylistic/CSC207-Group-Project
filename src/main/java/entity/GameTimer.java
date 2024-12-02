package entity;

import java.util.Timer;
import java.util.TimerTask;

import data_access.Constants;

/**
 * Timer to keep track of the time elapsed of current game.
 */
public class GameTimer {
    private final Timer timer = new Timer();
    private int secondsElapsed;
    private final Runnable onTimeUpCallback;
    private Runnable onTickCallback;
    private boolean isRunning;

    public GameTimer(Runnable onTimeUpCallback, Runnable onTickCallback) {
        this.secondsElapsed = 0;
        this.onTimeUpCallback = onTimeUpCallback;
        this.onTickCallback = onTickCallback;
    }

    /**
     * Starts our timer to start counting.
     * @param newOnTickCallback Runnable to count
     */
    public void start(Runnable newOnTickCallback) {
        this.onTickCallback = newOnTickCallback;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondsElapsed++;
                if (onTickCallback != null) {
                    onTickCallback.run();
                }
            }
        }, 0, Constants.THOUSAND);
    }

    /**
     * Stops our timer.
     */
    public void stop() {
        timer.cancel();
        isRunning = false;
    }

    public int getSecondsElapsed() {
        return secondsElapsed;
    }

    /**
     * Setter for our onTickCallback.
     * @param onTickCallback the value to set our onTickCallback to
     */
    public void setOnTickCallback(Runnable onTickCallback) {
        this.onTickCallback = onTickCallback;
        if (onTickCallback != null) {
            onTickCallback.run();
        }
    }
}
