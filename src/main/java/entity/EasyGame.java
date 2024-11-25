package entity;

import java.util.List;

/**
 * Easy Game - No modifications to parent class.
 */
public class EasyGame extends AbstractGame {
    public EasyGame(List<QuestionAnswer> questionAnswers) {
        super(questionAnswers, "easy");
    }
}
