package ui.Panels;

import game.Game;
import game.GameInputs;
import ui.DialogBoxes.DialogBoxStart;
import ui.DialogBoxes.DialogBoxWeaponsStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private MapPanel mapPanel;
    private InventoryPanel inventoryPanel;
    private PlayerInfoPanel playerInfoPanel;
    private Game playerInfo;

    public GamePanel(Game game) {
        // Game Panel Noir
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        // Map dans la GamePanel
        this.mapPanel = new MapPanel(game.getMap());
        this.add(mapPanel, BorderLayout.NORTH);

        // Add InventoryPanel to GamePanel
        // this.inventoryPanel = new InventoryPanel(this); // Pass the GamePanel itself
        // this.add(inventoryPanel, BorderLayout.WEST);

        // Add the name and the cast of the player in the center of the GamePanel
        //this.playerInfo = new Game(game.getPlayer());
        //this.add(playerInfo, BorderLayout.CENTER);

        //GameInputs gameInputs = new GameInputs();
        //new DialogBoxStart(gameInputs);
        //System.out.println(gameInputs.getPlayerName());
        //System.out.println(gameInputs.getPlayerCast());


        // Add InventoryPanel to GamePanel
        //GameInputs gameInputs = new GameInputs();
        //new DialogBoxStart(gameInputs);
        //System.out.println(gameInputs.getPlayerName());
        //System.out.println(gameInputs.getPlayerCast());

        // Add buttons to the GamePanel
        JButton showWeaponsButton = new JButton("Show Weapons");
        JButton weaponStoreButton = new JButton("Weapon Store");

        weaponStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogBoxWeaponsStore weaponsDialog = new DialogBoxWeaponsStore((JFrame) SwingUtilities.getWindowAncestor(GamePanel.this));
                weaponsDialog.setVisible(true);
            }
        });

        JButton quitButton = new JButton("Quit");
        // Add ActionListener to the Quit button
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(showWeaponsButton);
        buttonPanel.add(weaponStoreButton);
        buttonPanel.add(quitButton);

        // Add the button panel to the GamePanel
        this.add(buttonPanel, BorderLayout.WEST);

        // Add PlayerInfoPanel to GamePanel
        this.playerInfoPanel = new PlayerInfoPanel(game.getPlayer()); // Crée une instance
        this.add(playerInfoPanel, BorderLayout.SOUTH); // Ajoute l'instance à la GamePanel

        // Add PlayerCast to GamePanel (getPlayerCast() returns a JPanel)
        //this.playerCast = new PlayerInfoPanel(game.getPlayer()); // Crée une instance
        //this.add(game.getPlayer().getPlayerCast(), BorderLayout.CENTER);


        // Set an empty border to remove the scrollbar
        this.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }
}
