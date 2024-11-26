package app;

import data_access.GameDataAccessObject;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import use_case.game.GameDataAccessInterface;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class GameApplicationTest {

    private JFrame app;

    @Before
    public void setUp() throws Exception {
        final GameDataAccessInterface gameDataAccess = new GameDataAccessObject();

        final GameAppBuilder gameBuilder = new GameAppBuilder();
        gameBuilder.addGameDao(gameDataAccess)
                .addGameView()
                .addGameUseCase()
                .build().setVisible(true);
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
    }

}
