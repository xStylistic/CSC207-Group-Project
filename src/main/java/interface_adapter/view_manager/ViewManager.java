package interface_adapter.view_manager;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data_access.Constants;
import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;
import view.DifficultyView;
import view.EasyQuestionView;
import view.EndScreenView;
import view.GameView;
import view.HardQuestionView;
import view.MediumQuestionView;
import view.UnlockNewAnimalView;

/**
 * The Manager of the views.
 */
public class ViewManager {
    private final JFrame layout;
    private JPanel currView;

    public ViewManager(GameViewModel gameViewModel, GameController gameController) {
        this.layout = new JFrame();

        final GameView gameView = new GameView(gameViewModel);
        gameView.setGameController(gameController);
        gameView.setVisible(true);
        layout.add(gameView);

        // Listen for view change requests
        gameViewModel.addPropertyChangeListener(
                evt -> handleViewChange(evt.getPropertyName(), gameViewModel, gameController, gameView));

        layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout.setMinimumSize(new Dimension(Constants.NINEHUNDREDTWENTYSEVEN, Constants.FIVEHUNDREDNINETYONE));
        layout.setPreferredSize(new Dimension(Constants.NINEHUNDREDTWENTYSEVEN, Constants.FIVEHUNDREDNINETYONE));
    }

    public ViewManager(JFrame layout) {
        this.layout = layout;
    }

    private void handleViewChange(
            String propertyName, GameViewModel gameViewModel, GameController gameController, GameView gameView) {
        if ("pageChange".equals(propertyName)) {
            final String viewName = gameViewModel.getViewName();

            if ("difficulty".equals(viewName)) {
                final DifficultyView difficultyView = new DifficultyView(gameViewModel, gameController);
                this.currView = difficultyView;
                difficultyView.setVisible(true);

                // TESTING with logs :)
                final GameState state = gameViewModel.getState();
                System.out.println(state.getDifficulty());

                layout.remove(gameView);
                layout.add(difficultyView);
                layout.revalidate();
                layout.repaint();
            }
            else if ("questions".equals(viewName)) {
                // Render depending on which type of question it is on
                // check type of question
                final int difficulty = gameViewModel.getState().getDifficulty();

                layout.remove(currView);
                // EASY = 0
                if (difficulty == 0) {
                    final EasyQuestionView easyQuestionView = new EasyQuestionView(gameViewModel);
                    easyQuestionView.setQuestionController(gameController);
                    easyQuestionView.setVisible(true);

                    this.currView = easyQuestionView;
                    layout.add(easyQuestionView);
                }
                // MEDIUM = 1
                else if (difficulty == 1) {
                    final MediumQuestionView mediumQuestionView = new MediumQuestionView(gameViewModel);
                    mediumQuestionView.setQuestionController(gameController);
                    mediumQuestionView.setVisible(true);

                    this.currView = mediumQuestionView;
                    layout.add(mediumQuestionView);
                }
                // HARD = 2
                else if (difficulty == 2) {
                    final HardQuestionView hardQuestionView = new HardQuestionView(gameViewModel);
                    hardQuestionView.setQuestionController(gameController);
                    hardQuestionView.setVisible(true);

                    this.currView = hardQuestionView;
                    layout.add(hardQuestionView);
                }

                layout.revalidate();
                layout.repaint();
            }
            else if ("reward".equals(viewName)) {
                layout.remove(currView);

                final UnlockNewAnimalView unlockNewAnimalView = new UnlockNewAnimalView(gameViewModel);
                unlockNewAnimalView.setQuestionController(gameController);
                unlockNewAnimalView.setVisible(true);

                this.currView = unlockNewAnimalView;
                layout.add(unlockNewAnimalView);
                layout.revalidate();
                layout.repaint();
            }
            else if ("end".equals(viewName)) {
                final EndScreenView endScreenView = new EndScreenView(gameController);
                endScreenView.setVisible(true);

                layout.remove(currView);
                this.currView = endScreenView;
                layout.add(endScreenView);
                layout.revalidate();
                layout.repaint();
            }

            System.out.println("VIEW CHANGED!");
        }
    }

    public JFrame getCurrLayout() {
        return this.layout;
    }
}
