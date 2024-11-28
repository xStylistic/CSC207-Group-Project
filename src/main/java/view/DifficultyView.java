package view;

import interface_adapter.game.GameController;
import interface_adapter.game.GameViewModel;

/**
 * The Blueprint for the difficulty view.
 */
public class DifficultyView extends javax.swing.JPanel {
    private GameViewModel gameViewModel;
    private GameController gameController;
    private javax.swing.JLabel background;
    private javax.swing.JPanel difficultyPanel;
    private javax.swing.JButton easy;
    private javax.swing.JButton hard;
    private javax.swing.JButton medium;
    private javax.swing.JLabel title;

    /**
     * Creates new form DifficultyView.
     * @param gameViewModel the gameViewModel
     * @param gameController the gameController
     */
    public DifficultyView(GameViewModel gameViewModel, GameController gameController) {
        this.gameViewModel = gameViewModel;
        this.gameController = gameController;
        initComponents();
    }

    private void initComponents() {

        difficultyPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        easy = new javax.swing.JButton();
        medium = new javax.swing.JButton();
        hard = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        difficultyPanel.setBackground(new java.awt.Color(255, 183, 132));

        title.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); 
        title.setText("CHOOSE YOUR DIFFICULTY");

        easy.setBackground(new java.awt.Color(165, 235, 165));
        easy.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); 
        easy.setText("EASY");
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyActionPerformed(evt);
            }
        });

        medium.setBackground(new java.awt.Color(255, 204, 51));
        medium.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); 
        medium.setText("MEDIUM");
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });

        hard.setBackground(new java.awt.Color(255, 102, 102));
        hard.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); 
        hard.setText("HARD");
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardActionPerformed(evt);
            }
        });

        final javax.swing.GroupLayout difficultyPanelLayout = new javax.swing.GroupLayout(difficultyPanel);
        difficultyPanel.setLayout(difficultyPanelLayout);
        difficultyPanelLayout.setHorizontalGroup(
            difficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(difficultyPanelLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(difficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(easy, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(medium, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(hard, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, difficultyPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(42, 42, 42))
        );
        difficultyPanelLayout.setVerticalGroup(
            difficultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(difficultyPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(title)
                .addGap(40, 40, 40)
                .addComponent(easy, javax.swing.GroupLayout.PREFERRED_SIZE,
                        59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(medium, javax.swing.GroupLayout.PREFERRED_SIZE,
                        59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(hard, javax.swing.GroupLayout.PREFERRED_SIZE,
                        59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        // Add components directly to this panel instead of getContentPane()
        add(difficultyPanel);
        difficultyPanel.setBounds(230, 90, 470, 420);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png")));
        add(background);
        background.setBounds(0, 0, 927, 591);
        // Set the size to the background img size, and centre the image.
        setPreferredSize(new java.awt.Dimension(927, 591));
    }

    private void easyActionPerformed(java.awt.event.ActionEvent evt) {
        this.gameViewModel.getState().setDifficulty(0);
        System.out.println("SET DIFFICULTY TO 0");
        // Create Game with difficulty 0 = EASY
        triggerGameStartSwitchView(0);
    }

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) {
        this.gameViewModel.getState().setDifficulty(1);
        System.out.println("SET DIFFICULTY TO 1");
        // Create Game with difficulty 1 = MEDIUM
        triggerGameStartSwitchView(1);
    }

    private void hardActionPerformed(java.awt.event.ActionEvent evt) {
        this.gameViewModel.getState().setDifficulty(2);
        System.out.println("SET DIFFICULTY TO 2");
        // Create Game with Difficulty 2 = HARD
        triggerGameStartSwitchView(2);
    }

    private void triggerGameStartSwitchView(int difficulty) {
        gameController.startGame(difficulty);
    }
}
