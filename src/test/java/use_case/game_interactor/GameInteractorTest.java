package use_case.game_interactor;

import data_access.FileDataAccessObject;
import entity.QuestionAnswer;
import entity.User;
import use_case.retrieveFile.FileInteractor;
import use_case.retrieveFile.FileOutputBoundary;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class GameInteractorTest {

    FileDataAccessObject fileDAO = new FileDataAccessObject() {
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

    FileOutputBoundary fileOB = new FileOutputBoundary() {
        @Override
        public void prepareSuccessView(File message) {

        }

        @Override
        public void prepareFailView(String errorMessage) {

        }

        @Override
        public void prepareQuestionView(QuestionAnswer firstQuestion, Integer answerTimes) {

        }

        @Override
        public void prepareEndGameView() {

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


    FileInteractor gameInteractor = new FileInteractor(fileDAO, fileOB);
    ArrayList<String> test = new ArrayList<>();
    File testfile = new File("test.txt");

//    void assertEquals(gameInteractor.executeRetrieval(), testfile);


}
