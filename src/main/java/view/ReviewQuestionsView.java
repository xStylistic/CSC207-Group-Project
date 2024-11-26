package view;

/**
 *
 * @author beam
 */
public class ReviewQuestionsView extends javax.swing.JFrame {

    private javax.swing.JButton mainMenuButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel incorrectQuestionsLabel;
    private javax.swing.JPanel reviewPanel;
    private javax.swing.JScrollPane reviewScroll;
    private javax.swing.JTable reviewAnswersTable;

    public ReviewQuestionsView() {
        initComponents();
    }

    private void initComponents() {

        reviewPanel = new javax.swing.JPanel();
        incorrectQuestionsLabel = new javax.swing.JLabel();
        reviewScroll = new javax.swing.JScrollPane();
        reviewAnswersTable = new javax.swing.JTable();
        mainMenuButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        reviewPanel.setBackground(new java.awt.Color(255, 204, 153));

        incorrectQuestionsLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); 
        incorrectQuestionsLabel.setText("Incorrect Questions");

        reviewAnswersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Question", "Your Answer", "Correct"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        reviewScroll.setViewportView(reviewAnswersTable);

        mainMenuButton.setBackground(new java.awt.Color(255, 255, 204));
        mainMenuButton.setText("Main Menu");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reviewPanelLayout = new javax.swing.GroupLayout(reviewPanel);
        reviewPanel.setLayout(reviewPanelLayout);
        reviewPanelLayout.setHorizontalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanelLayout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addComponent(reviewScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanelLayout.createSequentialGroup()
                        .addComponent(incorrectQuestionsLabel)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanelLayout.createSequentialGroup()
                        .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))))
        );
        reviewPanelLayout.setVerticalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(incorrectQuestionsLabel)
                .addGap(18, 18, 18)
                .addComponent(reviewScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(reviewPanel);
        reviewPanel.setBounds(180, 70, 580, 420);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/farm.png"))); 
        getContentPane().add(background);
        background.setBounds(6, 6, 927, 591);

        pack();
    }

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
