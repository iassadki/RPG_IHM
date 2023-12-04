package game;

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

    public boolean isValidPosition(int newRow, int newCol) {
        return newRow >= 0 && newRow < this.map.length && newCol >= 0 && newCol < this.map[0].length;
    }

    public int getNumRows() {
        return this.map.length;
    }

    public int getNumCols() {
        return this.map[0].length;
    }
}

