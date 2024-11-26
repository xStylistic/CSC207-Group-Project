package interface_adapter.view_manager;
import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;
import view.*;

import javax.swing.*;
import java.awt.*;

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
                evt -> {
                    if (evt.getPropertyName().equals("pageChange")) {
                        String viewName = gameViewModel.getViewName();

                        if (viewName.equals("difficulty")) // SETTING CURRENT PAGE TO BE DIFFICULTY
                        {
                            final DifficultyView difficultyView = new DifficultyView(gameViewModel, gameController);
                            this.currView = difficultyView;
                            difficultyView.setVisible(true);

                            // TESTING with logs :)
                            GameState state = gameViewModel.getState();
                            System.out.println(state.getDifficulty());

                            layout.remove(gameView);
                            layout.add(difficultyView);
                            layout.revalidate();
                            layout.repaint();
                        }
                        else if (viewName.equals("questions")) // SETTING CURRENT PAGE TO BE QUESTIONS
                        {

                            // Render depending on which type of question it is on
                            // check type of question
                            int difficulty = gameViewModel.getState().getDifficulty();

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
                        else if (viewName.equals("reward")) // Going to Reward Page
                        {
                            layout.remove(currView);

                            final UnlockNewAnimalView unlockNewAnimalView = new UnlockNewAnimalView(gameViewModel);
                            unlockNewAnimalView.setQuestionController(gameController);
                            unlockNewAnimalView.setVisible(true);

                            this.currView = unlockNewAnimalView;
                            layout.add(unlockNewAnimalView);
                            layout.revalidate();
                            layout.repaint();
                        }
                        else if (viewName.equals("end"))    // Going to the end screen
                        {
                            final EndScreenView endScreenView = new EndScreenView();
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
        );

        layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout.setMinimumSize(new Dimension(927, 591));  // Set minimum size
        layout.setPreferredSize(new Dimension(927, 591));  // Set minimum size
    }

    public JFrame getCurrLayout() {
        return this.layout;
    }
}
