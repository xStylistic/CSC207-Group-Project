package entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAnswerTest {

    @Test
    public void testGetQuestion() {
        QuestionAnswer questAns = new QuestionAnswer("What is the constant for g", "9.81");
        assertEquals("What is the constant for g", questAns.getQuestion());
    }

    @Test
    public void testGetAnswer() {
        QuestionAnswer questAns = new QuestionAnswer("What is the constant for g", "9.81");
        assertEquals("9.81", questAns.getCorrectAnswer());
    }

    @Test
    public void testSetUserAnswer() {
        QuestionAnswer questAns = new QuestionAnswer("What is the constant for g", "9.81");
        questAns.setUserAnswer("10");
        assertEquals("10", questAns.getUserAnswer());
    }

    @Test
    public void testValidateAnswerCorrect() {
        QuestionAnswer questAns = new QuestionAnswer("What is the constant for g", "9.81");
        questAns.setUserAnswer("9.81");
        assertTrue(questAns.validateAnswer());
    }

    @Test
    public void testValidateAnswerWrong() {
        QuestionAnswer questAns = new QuestionAnswer("What is the constant for g", "9.81");
        questAns.setUserAnswer("10");
        assertFalse(questAns.validateAnswer());
    }

    @Test
    public void testTimeUp() {
        QuestionAnswer questAns = new QuestionAnswer("What is the constant for g", "9.81");
        questAns.setUserAnswer("10");
        questAns.setIsTimeUp();
        assertTrue(questAns.getIsTimeUp());
    }

    @Test
    public void testSetQuestion() {
        QuestionAnswer questAns = new QuestionAnswer("What is the constant for g", "9.81");
        questAns.setQuestion("What is 5*2");
        questAns.setUserAnswer("10");
        assertEquals("What is 5*2", questAns.getQuestion());
    }

}
