package ui.DialogBoxes;

import javax.swing.*;
import java.awt.*;

public class DialogBoxWeaponsStore extends JDialog {

    public DialogBoxWeaponsStore(JFrame parent) {
        super(parent, "Weapons Store", true);
        setLayout(new BorderLayout());

        // Créer un panneau vide
        JPanel emptyPanel = new JPanel();

        // Ajouter le panneau à la boîte de dialogue
        add(emptyPanel, BorderLayout.CENTER);

        // Fixer la taille de la boîte de dialogue à 500x500
        setSize(500, 500);

        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Exemple d'utilisation
            JFrame frame = new JFrame("Example Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton openDialogButton = new JButton("Open Weapons Dialog");
            openDialogButton.addActionListener(e -> {
                DialogBoxWeaponsStore weaponsDialog = new DialogBoxWeaponsStore(frame);
                weaponsDialog.setVisible(true);
            });

            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(openDialogButton);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
