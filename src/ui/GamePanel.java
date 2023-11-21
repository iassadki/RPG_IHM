package ui;

import game.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MapPanel mapPanel;

    public GamePanel(Game game) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        // Add MapPanel to GamePanel
        this.mapPanel = new MapPanel(game.getMap());
        this.add(mapPanel, BorderLayout.NORTH);

        //TODO: Add PlayerInfoPanel to GamePanel
        //PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(game.getPlayer());
        //this.add(playerInfoPanel, BorderLayout.SOUTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }
}
