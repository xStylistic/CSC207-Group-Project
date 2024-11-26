package view;

/**
 *
 * @author bonnychen
 */


// This happens at one question wrong for hard
public class GameOverView extends javax.swing.JPanel {

    public GameOverView() {
        initComponents();
    }

    private void initComponents() {

        gameOverPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mainMenuButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        gameOverPanel.setBackground(new java.awt.Color(255, 204, 102));

        titleLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); 
        titleLabel.setText("All your animals have died :(");

        mainMenuButton.setBackground(new java.awt.Color(255, 238, 173));
        mainMenuButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); 
        mainMenuButton.setText("Main Menu");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        restartButton.setBackground(new java.awt.Color(255, 238, 173));
        restartButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); 
        restartButton.setText("Restart");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameOverPanelLayout = new javax.swing.GroupLayout(gameOverPanel);
        gameOverPanel.setLayout(gameOverPanelLayout);
        gameOverPanelLayout.setHorizontalGroup(
            gameOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameOverPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameOverPanelLayout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addGroup(gameOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );
        gameOverPanelLayout.setVerticalGroup(
            gameOverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameOverPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(titleLabel)
                .addGap(41, 41, 41)
                .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        add(gameOverPanel);
        gameOverPanel.setBounds(260, 110, 400, 340);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png"))); 
        add(background);
        background.setBounds(0, 0, 940, 570);
    }

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private javax.swing.JPanel gameOverPanel;
    private javax.swing.JLabel background;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel titleLabel;
}
