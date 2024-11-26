package view;

public class EndScreenView extends javax.swing.JPanel {

    public EndScreenView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        endScreenPanel = new javax.swing.JPanel();
        scoreBoard = new javax.swing.JPanel();
        score = new javax.swing.JLabel();
        totalTime = new javax.swing.JLabel();
        averageTime = new javax.swing.JLabel();
        animalsKilled = new javax.swing.JLabel();
        reviewAnswers = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        // Make endScreenPanel similar size to difficultyPanel
        endScreenPanel.setBackground(new java.awt.Color(255, 183, 132));
        endScreenPanel.setBounds(230, 90, 470, 420);  // Same as difficultyPanel

        scoreBoard.setBackground(new java.awt.Color(241, 190, 121));

        score.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        score.setText("Score: (insert the score)");

        totalTime.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        totalTime.setText("Total Spent: (time spent)");

        averageTime.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        averageTime.setText("Average Time Per Question: (time spent)");

        animalsKilled.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        animalsKilled.setText("Animals Killed: (number of animals)");

        reviewAnswers.setBackground(new java.awt.Color(255, 234, 168));
        reviewAnswers.setText("Review Answers");

        // Keep existing scoreBoard layout
        javax.swing.GroupLayout scoreBoardLayout = new javax.swing.GroupLayout(scoreBoard);
        scoreBoard.setLayout(scoreBoardLayout);
        scoreBoardLayout.setHorizontalGroup(
                scoreBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scoreBoardLayout.createSequentialGroup()
                                .addContainerGap(56, Short.MAX_VALUE)
                                .addGroup(scoreBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalTime)
                                        .addComponent(averageTime)
                                        .addComponent(score)
                                        .addComponent(animalsKilled))
                                .addGap(47, 47, 47))
                        .addGroup(scoreBoardLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(reviewAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scoreBoardLayout.setVerticalGroup(
                scoreBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(scoreBoardLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(score)
                                .addGap(28, 28, 28)
                                .addComponent(totalTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(averageTime)
                                .addGap(12, 12, 12)
                                .addComponent(animalsKilled)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(reviewAnswers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        // Add scoreBoard to endScreenPanel instead of directly to the main panel
        endScreenPanel.add(scoreBoard);
        add(endScreenPanel);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png")));
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 927, 591);

        setPreferredSize(new java.awt.Dimension(927, 591));

    }

    // Variables declaration
    private javax.swing.JLabel animalsKilled;
    private javax.swing.JLabel averageTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reviewAnswers;
    private javax.swing.JLabel score;
    private javax.swing.JPanel scoreBoard;
    private javax.swing.JLabel totalTime;
    private javax.swing.JPanel endScreenPanel;
}