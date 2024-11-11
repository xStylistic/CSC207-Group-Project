package data_access;

import entity.User;
import use_case.file.DataAccessException;
import use_case.file.FileDataAccessInterface;

import javax.swing.*;
import java.io.File;

/**
 * The DAO for requesting and saving input file.
 */
public class FileDataAccessObject implements FileDataAccessInterface {
    @Override
    public File requestFile(User user) throws DataAccessException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a TXT File");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
}