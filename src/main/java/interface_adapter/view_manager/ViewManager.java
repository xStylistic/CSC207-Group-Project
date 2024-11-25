package interface_adapter.view_manager;
import interface_adapter.game.GameController;
import interface_adapter.game.GameState;
import interface_adapter.game.GameViewModel;
import view.DifficultyView;
import view.GameView;
import view.QuestionAnswerView;

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
                            final QuestionAnswerView questionAnswerView = new QuestionAnswerView(gameViewModel);
                            questionAnswerView.setQuestionController(gameController);
                            questionAnswerView.setVisible(true);

                            layout.remove(currView);
                            this.currView = questionAnswerView;
                            layout.add(questionAnswerView);
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
