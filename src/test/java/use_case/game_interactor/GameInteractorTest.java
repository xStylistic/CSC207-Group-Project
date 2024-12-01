package use_case.game_interactor;

import data_access.GameDataAccessObject;
import entity.AbstractGame;
import entity.QuestionAnswer;
import entity.User;
import use_case.game.GameInteractor;
import use_case.game.GameOutputBoundary;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class GameInteractorTest {

    GameDataAccessObject gameDAO = new GameDataAccessObject() {
        @Override
        public File requestFile(User user) {
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a TXT File");
            final int result = fileChooser.showOpenDialog(null);
            File file = null;

            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            }
            return file;
        }

    };

    GameOutputBoundary gameOB = new GameOutputBoundary() {
        @Override
        public void prepareSuccessView(File message) {

        }

        @Override
        public void prepareFailView(String errorMessage) {

        }

        @Override
        public void prepareQuestionView(QuestionAnswer firstQuestion, AbstractGame game) {

        }

        @Override
        public void prepareEndGameView(AbstractGame game) {

        }

        @Override
        public void prepareAnswerResultView(QuestionAnswer questionAnswer) {

        }

        @Override
        public void prepareAnswerConfirmView(QuestionAnswer currentQuestionAnswer) {

        }

        @Override
        public void prepareDifficultyView() {

        }
    };


    GameInteractor gameInteractor = new GameInteractor(gameDAO, gameOB);
    ArrayList<String> test = new ArrayList<>();
    File testfile = new File("test.txt");

//    void assertEquals(gameInteractor.executeRetrieval(), testfile);


}
