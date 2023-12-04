package ui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.DialogBoxes.DialogBoxWeaponsStore;

public class WeaponsPanel extends JPanel {

    private JRadioButton hammerRadio;
    private JRadioButton bowRadio;
    private JRadioButton axeRadio;

    public WeaponsPanel() {
        setLayout(new GridLayout(3, 1));

        hammerRadio = new JRadioButton("Hammer");
        bowRadio = new JRadioButton("Bow");
        axeRadio = new JRadioButton("Axe");

        ButtonGroup weaponsGroup = new ButtonGroup();
        weaponsGroup.add(hammerRadio);
        weaponsGroup.add(bowRadio);
        weaponsGroup.add(axeRadio);

        add(hammerRadio);
        add(bowRadio);
        add(axeRadio);
    }

    public String getSelectedWeapon() {
        if (hammerRadio.isSelected()) {
            return "Hammer";
        } else if (bowRadio.isSelected()) {
            return "Bow";
        } else if (axeRadio.isSelected()) {
            return "Axe";
        } else {
            return "Aucune arme sélectionnée";
        }
    }
}