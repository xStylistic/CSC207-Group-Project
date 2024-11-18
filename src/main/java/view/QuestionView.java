package view;

/**
 * Questions.
 */
public class QuestionView extends javax.swing.JFrame {

    private javax.swing.JTextField answer;
    private javax.swing.JLabel background;
    private javax.swing.JButton checkAnswer;
    private javax.swing.JLabel question;
    private javax.swing.JLabel questionNumber;
    private javax.swing.JLabel timer;

    /**
     * Creates new form QuestionView.
     */
    public QuestionView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        answer = new javax.swing.JTextField();
        timer = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        checkAnswer = new javax.swing.JButton();
        questionNumber = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });
        getContentPane().add(answer);
        answer.setBounds(30, 80, 510, 70);

        timer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        timer.setText("Time");
        getContentPane().add(timer);
        timer.setBounds(510, 20, 34, 22);

        question.setFont(new java.awt.Font("Segoe UI", 0, 14));
        question.setText("The question");
        getContentPane().add(question);
        question.setBounds(30, 50, 140, 20);

        checkAnswer.setBackground(new java.awt.Color(255, 210, 163));
        checkAnswer.setText("Check Answer");
        checkAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAnswerActionPerformed(evt);
            }
        });
        getContentPane().add(checkAnswer);
        checkAnswer.setBounds(230, 160, 110, 30);

        questionNumber.setFont(new java.awt.Font("Segoe UI", 0, 16));
        questionNumber.setText("Question -/-");
        getContentPane().add(questionNumber);
        questionNumber.setBounds(30, 20, 85, 22);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/farm.png")));
        background.setText("jLabel4");
        getContentPane().add(background);
        background.setBounds(0, 0, 580, 310);

        pack();
    }

    private void checkAnswerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
    }

    private void answerActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionView().setVisible(true);
            }
        });
    }
}
