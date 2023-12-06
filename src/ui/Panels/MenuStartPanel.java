package ui.Panels;

import game.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuStartPanel extends JPanel {

    private GameInputs gameInputs;

    private JLabel title;

    private JLabel pseudoLabel;
    private JTextField pseudoField;

    private JRadioButton radioMage;
    private JRadioButton radioWarrior;
    private JRadioButton radioElf;

    private JRadioButton hammerRadio; ////
    private JRadioButton bowRadio; ////
    private JRadioButton axeRadio; ////

    private JButton okButton;
    private JLabel weaponLabel;

    public MenuStartPanel(GameInputs gameInputs) {
        this.gameInputs = gameInputs;
        initComponents(); //
    }

    private void setPlayerName(String name) {
        this.gameInputs.setPlayerName(name);
    }

    private void setPlayerCast() {
        PlayerCast playerClass = null;
        if (this.radioMage.isSelected()) {
            playerClass = PlayerCast.MAGE;
        } else if (this.radioElf.isSelected()) {
            playerClass = PlayerCast.ELF;
        } else if (this.radioWarrior.isSelected()) {
            playerClass = PlayerCast.WARRIOR;
        }
        this.gameInputs.setPlayerCast(playerClass);
    }

    public String getSelectedWeapon() {
        if (hammerRadio.isSelected()) {
            return "HAMMER";
        } else if (bowRadio.isSelected()) {
            return "BOW";
        } else if (axeRadio.isSelected()) {
            return "AXE";
        } else {
            return "Aucune arme sélectionnée";
        }
    }

    private void initComponents() {

        // define components
        this.title = new JLabel("WELCOME TO MY RPG");
        this.pseudoLabel = new JLabel("Choose your name : ");
        this.pseudoField = new JTextField();

        // Player classes radio buttons
        this.radioMage = new JRadioButton("MAGE");
        this.radioWarrior = new JRadioButton("WARRIOR");
        this.radioElf = new JRadioButton("ELF");

        // Weapons radio buttons
        this.weaponLabel = new JLabel("Choose your weapon : ");
        this.hammerRadio = new JRadioButton("HAMMER");
        this.bowRadio = new JRadioButton("BOW");
        this.axeRadio = new JRadioButton("AXE");

        //ButtonGroup weaponsGroup = new ButtonGroup();
        //weaponsGroup.add(hammerRadio);
        //weaponsGroup.add(bowRadio);
        //weaponsGroup.add(axeRadio);

        //add(hammerRadio);
        //add(bowRadio);
        //add(axeRadio);

        // define panel layout
        this.setBorder(new EmptyBorder(50, 50, 50, 50));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        /* GridBagConstraints parameters :
            int gridx,
            int gridy,
            int gridwidth,
            int gridheight,
            double weightx,
            double weighty,
            int anchor,
            int fill,
            java.awt.Insets insets,
            int ipadx,
            int ipady
         */
        this.setLayout(gridbag);
        gbc.fill = GridBagConstraints.BOTH;

        // add components to panel
        // title
        this.title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        gbc.gridwidth = 3;  // 3 columns wide
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(this.title, gbc);
        this.add(this.title);

        // Player classes radio buttons
        // mage
        this.radioMage.setSelected(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioMage, gbc);
        this.add(this.radioMage);
        // elf
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioElf, gbc);
        this.add(this.radioElf);
        // warrior
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioWarrior, gbc);
        this.add(this.radioWarrior);

        // pseudo of the player
        this.add(this.pseudoLabel,
                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(50, 0, 30, 0), 0, 0));
        this.pseudoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTextField textField = (JTextField) e.getSource();
                    setPlayerName(textField.getText());
                    setPlayerCast();
                }
            }
        });
        this.add(this.pseudoField,
                new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(50, 0, 30, 0), 0, 0));

        // Weapons Label
        this.add(this.weaponLabel,
                new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(20, 0, 20, 0), 0, 0));

        // Weapons radio buttons
        // hammer
        this.hammerRadio.setSelected(true);
        gbc.gridx = 0;
        gbc.gridy = 4;  // Ajustement de la position en y pour les boutons d'armes
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.hammerRadio, gbc);
        this.add(this.hammerRadio);
        // bow
        gbc.gridx = 1;
        gbc.gridy = 4;  // Ajustement de la position en y pour les boutons d'armes
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.bowRadio, gbc);
        this.add(this.bowRadio);
        // axe
        gbc.gridx = 2;
        gbc.gridy = 4;  // Ajustement de la position en y pour les boutons d'armes
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.axeRadio, gbc);
        this.add(this.axeRadio);

        // ok button
        this.okButton = new JButton("OK");
        this.okButton.addActionListener(e -> {
            setPlayerName(this.pseudoField.getText());
            setPlayerCast();
            System.out.println("Arme choisie : " + getSelectedWeapon());
            this.setVisible(false);
        });
        gbc.gridx = 1;  // Ajustement de la position en x pour le bouton OK
        gbc.gridy = 5;  // Ajustement de la position en y pour le bouton OK
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.okButton, gbc);
        this.add(this.okButton);
    }
}
