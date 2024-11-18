package use_case.game;

import entity.User;
import java.io.File;
import java.nio.file.Files;

import java.util.*;

import entity.QuestionAnswer;
import entity.User;
import entity.Game;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The "Use Case Interactor" for our two File-related use cases of refreshing
 * the contents of the File and saving the contents of the File. Since they
 * are closely related, we have combined them here for simplicity.
 */
public class GameInteractor implements GameInputBoundary {

    private final GameDataAccessInterface gameDataAccessInterface;
    private final GameOutputBoundary gameOutputBoundary;
    private final User user = new User("jonathan_calver2", "abc123");
    private File file;

    private Game game;

    public GameInteractor(GameDataAccessInterface gameDataAccessInterface,
                          GameOutputBoundary gameOutputBoundary) {
        this.gameDataAccessInterface = gameDataAccessInterface;
        this.gameOutputBoundary = gameOutputBoundary;
        this.game = null;
    }

    /**
     * Executes the retrieve File use case.
     *
     * @return
     */
    @Override
    public File executeRetrieval() {
        try {
            this.file = gameDataAccessInterface.requestFile(user);
            gameOutputBoundary.prepareSuccessView(this.file);

            final List<QuestionAnswer> questionsAnswers = new ArrayList<>();

            try {
                List<String> lines = Files.readAllLines(file.toPath());

                Iterator<String> iterator = lines.iterator();
                if (iterator.hasNext()) {
                    iterator.next();
                }

                while (iterator.hasNext()) {
                    String[] line = iterator.next().split("\t");

                    if (line.length == 2) {
                        questionsAnswers.add(new QuestionAnswer(line[0], line[1]));
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException("Error reading the file: " + file.getName(), ex);
            }

            System.out.println(questionsAnswers);
            game = new Game(questionsAnswers);
        }
        catch (DataAccessException ex) {
            gameOutputBoundary.prepareFailView(ex.getMessage());
        }
        return file;
    }

    /**
     * Returns the Game instance.
     *
     * @return The Game object.
     */
    @Override
    public Game getGame() {
        return game;
    }

    /**
     * Starts the game by preparing the first question view.
     */
    @Override
    public void startGame() {
        if (game != null) {
            final QuestionAnswer firstQuestion = game.getCurrentQuestion();
            gameOutputBoundary.prepareQuestionView(firstQuestion);
        }
        else {
            gameOutputBoundary.prepareFailView("The game is not active");
        }
    }

    /**
     * Processes the user's answer and proceeds to the next question or ends the game.
     *
     * @param userAnswer The user's submitted answer.
     */
    @Override
    public void executeAnswerSubmit(String userAnswer) {
        if (game == null) {
            gameOutputBoundary.prepareFailView("The game is not active");
        }
        final QuestionAnswer currentQuestionAnswer = game.getCurrentQuestion();
        if (currentQuestionAnswer == null) {
            gameOutputBoundary.prepareEndGameView();
        }
        else {
//            game.submitAnswer(userAnswer);
            if (currentQuestionAnswer.validateAnswer()) {
                gameOutputBoundary.prepareAnswerResultView(currentQuestionAnswer);
            }
            else {
                gameOutputBoundary.prepareAnswerConfirmView(currentQuestionAnswer);
            }

            if (game.isGameFinished()) {
                gameOutputBoundary.prepareEndGameView();
            }
            else {
                gameOutputBoundary.prepareQuestionView(game.getCurrentQuestion());
            }
        }
    }

    public String getFileName()
    {
        return file.getName();
    }
}
