package ui.Panels;

import game.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoPanel extends JPanel {

    private final Player player;

    public PlayerInfoPanel(Player player) {
        this.player = player;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel playerNameLabel = new JLabel("Player Name: " + player.getName()+" " +
                "| Life: " + player.getLife()+" " +
                "| Money: "+player.getMoney()+" " +
                "| Cast: "+player.getCast().toString()+ " " +
                "| Weapons: "+player.getWeapons().toString());
        playerNameLabel.setForeground(Color.WHITE); // Set text color to white
        playerNameLabel.setHorizontalAlignment(JLabel.LEFT); // Center align text

        add(playerNameLabel, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 50); // Adjust the height as needed
    }
}
