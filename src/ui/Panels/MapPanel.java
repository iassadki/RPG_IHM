package ui.Panels;

import game.*;
import game.Game;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    static final int cellSize = 24;

    private static final int CoordX = 200;
    private static final int CoordY = 50;

    private char[][] mapGrid;

    private Image playerImage;
    private int playerRow;
    private int playerCol;

    public MapPanel(Map map) {
        this.mapGrid = map.getMap();
        ImageIcon img = new ImageIcon("C:\\Users\\ilias\\su-java\\RPG_IHM\\src\\assets\\link.png");
        this.playerImage = img.getImage();
        this.playerRow = 0;
        this.playerCol = 0;
    }

    public Image getPlayerImage() {
        return this.playerImage;
    }

    public void updatePlayerPosition(int row, int col) {
        // Set the color of the previous player position to white
        mapGrid[playerRow][playerCol] = ' '; // Assuming ' ' represents an empty cell

        this.playerRow = row;
        this.playerCol = col;
        repaint();  // Force the panel to redraw with the new player position

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int CoordX = 200;
        int CoordY = 50;

        for (int row = 0; row < this.mapGrid.length; row++) {
            for (int col = 0; col < this.mapGrid[0].length; col++) {
                Color color;
                switch (this.mapGrid[row][col]) {
                    //case 'P':
                        //color = new Color(0, 255, 255);
                        //break;
                    case 'M':
                        color = Color.BLACK;
                        break;
                    case 'E':
                        color = Color.GREEN;
                        break;
                    default:
                        color = Color.WHITE;
                }
                ;
                g.setColor(color);
                g.fillRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);

                g.setColor(Color.BLACK); // contours
                g.drawRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
            }
        }

        clearPlayerPosition();  // Effacez l'ancienne position du joueur
        g.drawImage(this.getPlayerImage(), CoordX + cellSize * this.playerCol, CoordY + cellSize * this.playerRow, null);
        this.requestFocusInWindow();  // Permet de forcer le focus sur le panneau pour que les touches du clavier soient prises en compte
    }

    public void clearPlayerPosition() {
        repaintCell(playerRow, playerCol);  // Réinitialisez la couleur de la cellule précédente
    }

    private void repaintCell(int row, int col) {
        this.repaint(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }
}
