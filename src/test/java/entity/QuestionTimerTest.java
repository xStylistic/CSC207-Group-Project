package entity;

import org.junit.Test;

import javax.swing.*;

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

//    @Test
//    public void testRemainingTime() {
//        QuestionTimer timer = new QuestionTimer(
//                10,
//                () -> {
//                    System.out.println("Time is up");
//                },
//                () -> {
//                    System.out.println("Tick");
//                }
//        );
//        assertEquals(10, timer.getTimeLimit());
//        timer.start(() -> SwingUtilities.invokeLater(() -> handleQuestionTimer()));
//        timer.stop();
//    }
}
