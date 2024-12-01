package entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionTimerTest {

    @Test
    public void testGetTimeLimit() {
        QuestionTimer timer = new QuestionTimer(
                100,
                () -> {
                    System.out.println("Time is up");
                },
                () -> {
                    System.out.println("Tick");
                }
        );
        assertEquals(100, timer.getTimeLimit());
    }

    @Test
    public void testRemainingTime() {
        QuestionTimer timer = new QuestionTimer(
                100,
                () -> {
                    System.out.println("Time is up");
                },
                () -> {
                    System.out.println("Tick");
                }
        );
        timer.start();
        assertEquals(100, timer.getTimeLimit());
        timer.stop();

    }
}
