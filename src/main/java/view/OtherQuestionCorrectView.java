package view;

/**
 *
 * @author bonnychen
 */
public class OtherQuestionCorrectView extends javax.swing.JFrame {

    public OtherQuestionCorrectView() {
        initComponents();
    }

    private void initComponents() {

        questionPanel = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        correctAnswer = new javax.swing.JTextArea();
        questionNumberLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        timeElapsedLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        questionPanel.setBackground(new java.awt.Color(255, 244, 214));

        nextButton.setBackground(new java.awt.Color(255, 204, 102));
        nextButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        nextButton.setText("Next Question");

        correctAnswer.setColumns(20);
        correctAnswer.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        correctAnswer.setRows(5);

        questionNumberLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        questionNumberLabel.setText("Question -/-");

        questionLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        questionLabel.setText("Question");

        timeElapsedLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        timeElapsedLabel.setText("Time Elapsed:");

        timerLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        timerLabel.setForeground(new java.awt.Color(255, 102, 102));
        timerLabel.setText("00:00");

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(questionNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timerLabel)
                .addGap(204, 204, 204)
                .addComponent(timeElapsedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(correctAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionNumberLabel)
                    .addComponent(timeElapsedLabel)
                    .addComponent(timerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(questionLabel)
                .addGap(109, 109, 109)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(correctAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE)))
        );

        getContentPane().add(questionPanel);
        questionPanel.setBounds(80, 40, 760, 230);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/farm.png"))); 
        getContentPane().add(background);
        background.setBounds(0, 0, 930, 591);

        pack();
    }

    private javax.swing.JLabel background;
    private javax.swing.JTextArea correctAnswer;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JLabel timeElapsedLabel;
    private javax.swing.JLabel timerLabel;
}
