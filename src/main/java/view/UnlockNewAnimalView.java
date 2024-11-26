package view;

/**
 *
 * @author bonnychen
 */
public class UnlockNewAnimalView extends javax.swing.JPanel {

    public UnlockNewAnimalView() {
        initComponents();
    }
    
    private void initComponents() {

        newAnimePanel = new javax.swing.JPanel();
        newAnimalHolderPanel = new javax.swing.JPanel();
        animal = new javax.swing.JLabel();
        animalLabel = new javax.swing.JLabel();
        funFactLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        newAnimePanel.setBackground(new java.awt.Color(255, 204, 102));

        newAnimalHolderPanel.setBackground(new java.awt.Color(255, 238, 173));

        animal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/alpaca.png"))); 

        animalLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        animalLabel.setText("Animal Name");

        funFactLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); 
        funFactLabel.setText("Fun Fact: ");

        javax.swing.GroupLayout newAnimalHolderPanelLayout = new javax.swing.GroupLayout(newAnimalHolderPanel);
        newAnimalHolderPanel.setLayout(newAnimalHolderPanelLayout);
        newAnimalHolderPanelLayout.setHorizontalGroup(
            newAnimalHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newAnimalHolderPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(animal)
                .addGap(18, 18, 18)
                .addGroup(newAnimalHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(funFactLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(animalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        newAnimalHolderPanelLayout.setVerticalGroup(
            newAnimalHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newAnimalHolderPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(animal)
                .addGap(31, 31, 31))
            .addGroup(newAnimalHolderPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(animalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(funFactLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titleLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); 
        titleLabel.setText("You unlocked a new animal! ");

        nextButton.setBackground(new java.awt.Color(255, 238, 173));
        nextButton.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); 
        nextButton.setText("Nice");

        javax.swing.GroupLayout newAnimePanelLayout = new javax.swing.GroupLayout(newAnimePanel);
        newAnimePanel.setLayout(newAnimePanelLayout);
        newAnimePanelLayout.setHorizontalGroup(
            newAnimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newAnimePanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(32, 32, 32))
            .addGroup(newAnimePanelLayout.createSequentialGroup()
                .addGroup(newAnimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newAnimePanelLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newAnimePanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(newAnimalHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newAnimePanelLayout.setVerticalGroup(
            newAnimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newAnimePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(titleLabel)
                .addGap(36, 36, 36)
                .addComponent(newAnimalHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        add(newAnimePanel);
        newAnimePanel.setBounds(260, 110, 400, 340);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png"))); 
        add(background);
        background.setBounds(0, 0, 927, 570);
    }

    private javax.swing.JLabel animal;
    private javax.swing.JLabel animalLabel;
    private javax.swing.JLabel background;
    private javax.swing.JLabel funFactLabel;
    private javax.swing.JPanel newAnimalHolderPanel;
    private javax.swing.JPanel newAnimePanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel titleLabel;
}
