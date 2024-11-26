package view;

import interface_adapter.game.GameController;
import interface_adapter.game.GameViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author bonnychen and jerryq0101
 */


// This happens every time difficulty correct.
public class UnlockNewAnimalView extends javax.swing.JPanel implements ActionListener, PropertyChangeListener{
    private final GameViewModel gameViewModel;
    private GameController gameController;
    private JPanel entireRewardAnimalPanel;

    public UnlockNewAnimalView(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
        this.gameViewModel.addPropertyChangeListener(this);
        this.entireRewardAnimalPanel = new JPanel();

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

        animal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alpaca.png")));

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

        nextButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(nextButton)) {
                        // justSubmitted is false since we should move on
                        gameController.goToNextQuestion(false);
                    }
                }
        );

        // Set null for all panels that need absolute positioning layout
        this.setLayout(null);
        entireRewardAnimalPanel.setLayout(null);

        // Set bounds for all panels
        entireRewardAnimalPanel.setBounds(0, 0, 927, 591);

        // Set up background
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farm.png")));
        background.setBounds(0, 0, 927, 591);

        // Center the newAnimePanel
        // calculate center position: (parent width - panel width)/2
        int x = (927 - 400)/2;  // 927 is parent width, 400 is panel width
        int y = (591 - 340)/2;  // 591 is parent height, 340 is panel height
        newAnimePanel.setBounds(x, y, 400, 340);  // This will center it

        // Add components to entireRewardAnimalPanel in order
        entireRewardAnimalPanel.add(newAnimePanel);
        entireRewardAnimalPanel.add(background);

        // Set the z-order (what appears on top)
        entireRewardAnimalPanel.setComponentZOrder(newAnimePanel, 0);  // On top
        entireRewardAnimalPanel.setComponentZOrder(background, 1);     // At back

        // Add the entireRewardAnimalPanel to the main panel
        this.add(entireRewardAnimalPanel);

        // Set the preferred size for the main panel
        setPreferredSize(new java.awt.Dimension(927, 591));
    }

    private javax.swing.JLabel animal;
    private javax.swing.JLabel animalLabel;
    private javax.swing.JLabel background;
    private javax.swing.JLabel funFactLabel;
    private javax.swing.JPanel newAnimalHolderPanel;
    private javax.swing.JPanel newAnimePanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel titleLabel;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO: Doesn't do anything yet, property change may not be necessary
    }

    public void setQuestionController(GameController controller) {
        this.gameController = controller;
    }
}
