package view;

/**
 *
 * @author bonnychen
 */
public class MediumQuestionView extends javax.swing.JFrame {

    public MediumQuestionView() {
        initComponents();
    }

    private void initComponents() {

        questionPanel = new javax.swing.JPanel();
        checkButton = new javax.swing.JButton();
        answer = new javax.swing.JTextArea();
        questionNumber = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        timeElapsed = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        questionPanel.setBackground(new java.awt.Color(255, 244, 214));

        checkButton.setBackground(new java.awt.Color(255, 204, 102));
        checkButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        checkButton.setText("Check Answer");

        answer.setColumns(20);
        answer.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        answer.setRows(5);

        questionNumber.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        questionNumber.setText("Question -/-");

        question.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        question.setText("Question");

        timeElapsed.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        timeElapsed.setText("Time Elapsed:");

        timerLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        timerLabel.setForeground(new java.awt.Color(255, 102, 102));
        timerLabel.setText("00:00");

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(questionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timerLabel)
                .addGap(204, 204, 204)
                .addComponent(timeElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionNumber)
                    .addComponent(timeElapsed)
                    .addComponent(timerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(question)
                .addGap(109, 109, 109)
                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE)))
        );

        getContentPane().add(questionPanel);
        questionPanel.setBounds(80, 40, 760, 230);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/farm.png"))); 
        getContentPane().add(background);
        background.setBounds(0, 0, 927, 591);

        pack();
    }

    private javax.swing.JTextArea answer;
    private javax.swing.JLabel background;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel question;
    private javax.swing.JLabel questionNumber;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JLabel timeElapsed;
}
