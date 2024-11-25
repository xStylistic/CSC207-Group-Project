package entity;

/**
 * Base QuestionAnswer Class.
 */
public class QuestionAnswer {
    private String question;
    private String correctAnswer;
    private String userAnswer;
    private Boolean isCorrect;

    public QuestionAnswer(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.isCorrect = null;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public Boolean isCorrect() {
        return isCorrect;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
        this.validateAnswer();
        return this.isCorrect;
    }

    public boolean validateAnswer() {
        this.isCorrect = correctAnswer.equalsIgnoreCase(userAnswer);
        return this.isCorrect;
    }
}
