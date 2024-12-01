package view;

import interface_adapter.game.GameController;

public class EndScreenView extends javax.swing.JPanel {
    private final GameController gameController;
    private javax.swing.JLabel animalsKilled;
    private javax.swing.JLabel averageTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reviewAnswers;
    private javax.swing.JLabel score;
    private javax.swing.JPanel scoreBoard;
    private javax.swing.JLabel totalTime;
    private javax.swing.JPanel endScreenPanel;

    public EndScreenView(GameController gameController) {
        this.gameController = gameController;
    private javax.swing.JLabel animalsKilled;
    private javax.swing.JLabel averageTime;
    private javax.swing.JLabel background;
    private javax.swing.JButton reviewAnswers;
    private javax.swing.JLabel score;
    private javax.swing.JPanel scoreBoard;
    private javax.swing.JLabel totalTime;
    private javax.swing.JPanel endScreenPanel;

    public EndScreenView() {
        initComponents();
    }

    private void initComponents() {
        endScreenPanel = new javax.swing.JPanel();
        scoreBoard = new javax.swing.JPanel();
        score = new javax.swing.JLabel();
        totalTime = new javax.swing.JLabel();
        averageTime = new javax.swing.JLabel();
        animalsKilled = new javax.swing.JLabel();
        reviewAnswers = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        java.awt.Color panelColor = new java.awt.Color(255, 183, 132);
        endScreenPanel.setBackground(panelColor);
        scoreBoard.setBackground(panelColor);

        int panelWidth = 400;
        int panelHeight = 320;
        int x = (927 - panelWidth) / 2;
        int y = (591 - panelHeight) / 2;
        endScreenPanel.setBounds(x, y, panelWidth, panelHeight);
        endScreenPanel.setLayout(null);

        // Text components with bold font
        java.awt.Font boldFont = new java.awt.Font("Helvetica Neue", java.awt.Font.BOLD, 16);

        score.setFont(boldFont);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setText("Score: " + this.gameController.getScore());

        totalTime.setFont(boldFont);
        totalTime.setHorizontalAlignment(SwingConstants.CENTER);
        totalTime.setText("Total Spent: " + this.gameController.getTotalTime());

        averageTime.setFont(boldFont);
        averageTime.setHorizontalAlignment(SwingConstants.CENTER);
        averageTime.setText("Average Time Per Question: " + this.gameController.getAverageTime());

        reviewAnswers.setBackground(new java.awt.Color(255, 234, 168));
        reviewAnswers.setFont(new java.awt.Font("Helvetica Neue", java.awt.Font.PLAIN, 14));
        reviewAnswers.setText("Review Answers");

        // Arrange components in scoreBoard
        scoreBoard.setLayout(null);
        scoreBoard.setBounds(10, 10, 380, 300);

        int labelHeight = 25;
        int spacing = 20;

        score.setBounds(10, 30, 360, labelHeight);
        totalTime.setBounds(10, 32 + labelHeight + spacing, 360, labelHeight);
        averageTime.setBounds(10, 32 + 2 * (labelHeight + spacing), 360, labelHeight);
        animalsKilled.setBounds(10, 32 + 3 * (labelHeight + spacing), 360, labelHeight);
        reviewAnswers.setBounds(115, 32 + 4 * (labelHeight + spacing) + 10, 150, 40);

        scoreBoard.add(score);
        scoreBoard.add(totalTime);
        scoreBoard.add(averageTime);
        scoreBoard.add(animalsKilled);
        scoreBoard.add(reviewAnswers);

        endScreenPanel.add(scoreBoard);

        add(endScreenPanel);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png")));
        background.setBounds(0, 0, 927, 591);
        add(background);

        setComponentZOrder(background, 1);
        setComponentZOrder(endScreenPanel, 0);

        setPreferredSize(new java.awt.Dimension(927, 591));
    }
}