package view;

import javax.swing.JPanel;

/**
 *
 * @author bonnychen
 */
public class EasyQuestionWrongView extends JPanel {

    public EasyQuestionWrongView() {
        initComponents();
    }
    private javax.swing.JTextArea answer;
    private javax.swing.JLabel background;
    private javax.swing.JTextArea correctAnswer;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton noButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JLabel timeElapsedLabel;
    private javax.swing.JLabel funFactLabel;
    private javax.swing.JLabel wasItCorrectLabel;
    private javax.swing.JButton yesButton;

    private void initComponents() {
        questionPanel = new JPanel();
        nextButton = new javax.swing.JButton();
        correctAnswer = new javax.swing.JTextArea();
        questionNumberLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        funFactLabel = new javax.swing.JLabel();
        timeElapsedLabel = new javax.swing.JLabel();
        answer = new javax.swing.JTextArea();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        wasItCorrectLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setLayout(null);

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

        answer.setColumns(20);
        answer.setFont(new java.awt.Font("Helvetica Neue", 0, 16));
        answer.setRows(5);

        yesButton.setBackground(new java.awt.Color(142, 211, 55));
        yesButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        yesButton.setText("YES");

        noButton.setBackground(new java.awt.Color(255, 102, 102));
        noButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        noButton.setText("NO");

        wasItCorrectLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16));
        wasItCorrectLabel.setText("Was your answer correct?");

        funFactLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        funFactLabel.setText("Fun Fact: [Add a fun fact here]");

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
                questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(questionPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(questionNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timeElapsedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                        .addGroup(questionPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, questionPanelLayout.createSequentialGroup()
                                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(questionPanelLayout.createSequentialGroup()
                                                                .addComponent(wasItCorrectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(correctAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                                                                .addComponent(noButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(56, Short.MAX_VALUE))
        );
        questionPanelLayout.setVerticalGroup(
                questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(questionNumberLabel)
                                        .addComponent(timeElapsedLabel))
                                .addGap(13, 13, 13)
                                .addComponent(questionLabel)
                                .addGap(12, 12, 12)
                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(answer, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                        .addComponent(correctAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yesButton)
                                        .addComponent(noButton)
                                        .addComponent(wasItCorrectLabel))
                                .addGap(18, 18, 18))
        );

        add(questionPanel);
        questionPanel.setBounds(80, 40, 760, 230);

        funFactLabel.setBounds(80, 280, 760, 30);
        add(funFactLabel);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/farm.png")));
        add(background);
        background.setBounds(0, 0, 927, 591);
    }
}