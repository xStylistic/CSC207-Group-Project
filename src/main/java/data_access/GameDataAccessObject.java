package data_access;

import java.io.File;

import javax.swing.JFileChooser;

import entity.User;
import use_case.game.DataAccessException;
import use_case.game.GameDataAccessInterface;

/**
 * The DAO for requesting and saving input file.
 */
public class GameDataAccessObject implements GameDataAccessInterface {
    @Override
    public File requestFile(User user) throws DataAccessException {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a TXT File");
        final int result = fileChooser.showOpenDialog(null);
        File file = null;

        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }
}
