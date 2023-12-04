package ui.Panels;

import game.*;
import ui.DialogBoxes.DialogBoxWeaponsStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {

    private MapPanel mapPanel;
    private InventoryPanel inventoryPanel;
    private PlayerInfoPanel playerInfoPanel;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        //addKeyListener((KeyListener) this); //
        setFocusable(true);

        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        this.mapPanel = new MapPanel(game.getMap());
        this.add(mapPanel, BorderLayout.NORTH);

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
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(showWeaponsButton);
        buttonPanel.add(weaponStoreButton);
        buttonPanel.add(quitButton);

        this.add(buttonPanel, BorderLayout.WEST);

        this.playerInfoPanel = new PlayerInfoPanel(game.getPlayer());
        this.add(playerInfoPanel, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createEmptyBorder());

        Player player = game.getPlayer();
        player.setMapPanel(mapPanel);  // Définir la référence à MapPanel dans Player

        this.mapPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // ...
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                Direction direction = null;

                switch (keyCode) {
                    case KeyEvent.VK_Z:
                        direction = Direction.UP;
                        break;
                    case KeyEvent.VK_S:
                        direction = Direction.DOWN;
                        break;
                    case KeyEvent.VK_D:
                        direction = Direction.RIGHT;
                        break;
                    case KeyEvent.VK_Q:
                        direction = Direction.LEFT;
                        break;
                }

                if (direction != null) {
                    game.getPlayer().move(direction);
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // ...
            }
        });

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        String message = "Appuyez sur Z, Q, S, D pour vous déplacer";
        int x = (getWidth() - g.getFontMetrics().stringWidth(message)) / 2;
        int y = getHeight() / 2;
        g.drawString(message, x, y);
    }
}
