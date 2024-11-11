package view;

import interface_adapter.file.FileController;
import interface_adapter.file.FileState;
import interface_adapter.file.FileViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * The View for when the user is adding a file into the program
 */
public class FileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final FileViewModel fileViewModel;
    private final JButton chooseFileButton = new JButton("Choose File");
    private FileController fileController;


    public FileView(FileViewModel fileViewModel) {
        this.fileViewModel = fileViewModel;
        this.fileViewModel.addPropertyChangeListener(this);

        final JPanel buttons = new JPanel();
        buttons.add(chooseFileButton);

        chooseFileButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(chooseFileButton)) {
                        fileController.execute();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final FileState state = (FileState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else if (state.getFile() != null) {
            JOptionPane.showMessageDialog(this, "File loaded successfully.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            SwingUtilities.getWindowAncestor(this).dispose();
        }
    }

    public void setFileController(FileController controller) {
        this.fileController = controller;
    }

}

