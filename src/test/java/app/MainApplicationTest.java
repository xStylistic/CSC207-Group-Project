package app;

import org.junit.Before;
import org.junit.Test;
import use_case.game.GameDataAccessInterface;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class MainApplicationTest {

    private JFrame app;

    @Before
    public void setUp() {

        // create the data access and inject it into our builder!
        final GameDataAccessInterface FileDataAccess = new GameDataAccessInterface() {

//            private String File = "test";

//            @Override
//            public String saveFile(User user, String File) {
//                this.File = File;
//                return File;
//            }
//
//            @Override
//            public String loadFile(User user) {
//                return File;
//            }
        };

        final FileLoaderAppBuilder builder = new FileLoaderAppBuilder();
        app = builder.addFileDAO(FileDataAccess)
                .addFileView()
                .addFileUseCase().build();

        app.setVisible(true);

    }

    /**
     * This is an example of an end-to-end test with a mocked database.
     * <p>The code creates the application and directly tests to see that the GUI
     * is updated as expected when the buttons and UI elements are interacted with.
     * </p>
     * You can run the test to visually see what happens.
     */
    @Test
    public void testEndToEnd() {

        Component[] components =  ((JPanel)app.getRootPane().getContentPane().getComponents()[0]).getComponents();
        JTextArea textArea = null;
        for (Component component : components) {
            if (component instanceof JTextArea) {
                textArea = (JTextArea) component;
                assertEquals("test", textArea.getText());

            }
        }

        textArea.setText("test test");


        JButton save = null;
        JButton load = null;
        for (Component component : components) {
            if (component instanceof JPanel) {
                for (Component c : ((JPanel) component).getComponents()) {
                    if (c instanceof JButton) {
                        if (save != null) {
                            load = (JButton) c;
                        }
                        else {
                            save = (JButton) c;
                        }
                    }
                }
            }
        }

        save.doClick();
        assertEquals("test test", textArea.getText());
        textArea.setText("");

        System.out.println("cleared text; about to refresh...");
        // pause execution for a bit so we can visually see the changes on the screen
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        load.doClick();
        assertEquals("test test", textArea.getText());

        System.out.println("after refresh!");

        // pause execution for a bit so we can visually see the changes on the screen
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}