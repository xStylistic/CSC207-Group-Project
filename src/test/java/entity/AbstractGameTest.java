package entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbstractGameTest {

    @Test
    public void testEasyGame() {
        QuestionAnswer q1 = new QuestionAnswer("question1", "answer1");
        QuestionAnswer q2 = new QuestionAnswer("question2", "answer2");
        QuestionAnswer q3 = new QuestionAnswer("question3", "answer3");
        List<QuestionAnswer> listOfQuestions = new ArrayList<>();
        listOfQuestions.add(q1);
        listOfQuestions.add(q2);
        listOfQuestions.add(q3);

        EasyGame easyGame = new EasyGame(listOfQuestions);
        assertEquals(q1, easyGame.getCurrentQuestion());
        assertEquals(0, easyGame.getNumberCorrect());
        easyGame.moveToNextQuestion();
        assertEquals(q2, easyGame.getCurrentQuestion());
    }

    @Test
    public void testMediumGame() {
        QuestionAnswer q1 = new QuestionAnswer("question1", "answer1");
        QuestionAnswer q2 = new QuestionAnswer("question2", "answer2");
        QuestionAnswer q3 = new QuestionAnswer("question3", "answer3");
        List<QuestionAnswer> listOfQuestions = new ArrayList<>();
        listOfQuestions.add(q1);
        listOfQuestions.add(q2);
        listOfQuestions.add(q3);

        MediumGame mediumGame = new MediumGame(listOfQuestions);
        assertEquals(q1, mediumGame.getCurrentQuestion());
        assertEquals(0, mediumGame.getNumberCorrect());
        mediumGame.moveToNextQuestion();
        assertEquals(q2, mediumGame.getCurrentQuestion());
    }

    @Test
    public void testHardGame() {
        QuestionAnswer q1 = new QuestionAnswer("question1", "answer1");
        QuestionAnswer q2 = new QuestionAnswer("question2", "answer2");
        QuestionAnswer q3 = new QuestionAnswer("question3", "answer3");
        List<QuestionAnswer> listOfQuestions = new ArrayList<>();
        listOfQuestions.add(q1);
        listOfQuestions.add(q2);
        listOfQuestions.add(q3);

        HardGame hardGame = new HardGame(listOfQuestions);
        assertEquals(q1, hardGame.getCurrentQuestion());
        assertEquals(0, hardGame.getNumberCorrect());
        hardGame.moveToNextQuestion();
        assertEquals(q2, hardGame.getCurrentQuestion());
    }

}
