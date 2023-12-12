package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.DialogBoxes.DialogBoxEnd;

public class Map {

    static final char[][] MAP_TEMPLATE_DEFAULT = {
            {'P', '0', 'M', 'M'},
            {'M', '0', 'M', 'M'},
            {'M', '0', '0', 'M'},
            {'M', 'M', '0', 'E'},
    };

    private char[][] map;

    public Map() {
        this.map = MAP_TEMPLATE_DEFAULT;
    }

    public char[][] getMap() {
        return this.map;
    }

    public void setPlayerPosition(int row, int col, int i) {
        this.map[row][col] = 'P';
    }

    public void getPlayerPosition(int row, int col) {
        this.map[row][col] = 'P';
    }

    public boolean isValidPosition(int newRow, int newCol) {
        return newRow >= 0 && newRow < this.map.length && newCol >= 0 && newCol < this.map[0].length;
    }

    public char getNextCell(int row, int col) {
        return this.map[row][col];
    }

    public boolean isFinish(int newRow, int newCol) {
        System.out.println("newRow: " + newRow + ", newCol: " + newCol);

        if (this.map[newRow][newCol] == 'E') {
            System.out.println("Vous avez gagné !");

            // Afficher la boîte de dialogue DialogBoxEnd
            DialogBoxEnd dialbox = new DialogBoxEnd();
            dialbox.showDialog();

            return true;
        }
        return false;
    }


    public int getNumRows() {
        return this.map.length;
    }

    public int getNumCols() {
        return this.map[0].length;
    }
}

