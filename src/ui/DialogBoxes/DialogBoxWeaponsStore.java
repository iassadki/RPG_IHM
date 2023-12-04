package ui.DialogBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.Panels.WeaponsPanel;

public class DialogBoxWeaponsStore extends JDialog {

    private WeaponsPanel weaponsPanel;
    private JButton chooseButton;

    public DialogBoxWeaponsStore(JFrame parent) {
        super(parent, "Magasin d'armes", true);
        setLayout(new BorderLayout());

        // Titre
        JLabel titleLabel = new JLabel("Bienvenue au magasin d'armes");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        // WeaponsPanel
        weaponsPanel = new WeaponsPanel();
        add(weaponsPanel, BorderLayout.CENTER);

        // Bouton "Choisir"
        chooseButton = new JButton("Choisir");
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedWeapon = weaponsPanel.getSelectedWeapon();
                JOptionPane.showMessageDialog(DialogBoxWeaponsStore.this,
                        "Vous avez choisi : " + selectedWeapon,
                        "Choix d'arme", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Ferme la boîte de dialogue après le choix
            }
        });
        add(chooseButton, BorderLayout.SOUTH);

        // Définir la taille fixe
        setSize(400, 300);

        // Centrer la boîte de dialogue sur l'écran
        setLocationRelativeTo(parent);

        // Indiquer que la boîte de dialogue se ferme lorsqu'on clique sur la croix
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JButton openDialogButton = new JButton("Ouvrir le magasin d'armes");
                openDialogButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DialogBoxWeaponsStore dialogBox = new DialogBoxWeaponsStore(frame);
                        dialogBox.setVisible(true);
                    }
                });
                frame.setLayout(new FlowLayout());
                frame.add(openDialogButton);
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}