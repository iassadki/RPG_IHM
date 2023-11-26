package game;

import java.awt.*;

public class Game {

    private Map map;

    private Player player;

    public Game(GameInputs gameInputs) {
        this.player = new Player(gameInputs.getPlayerName(), gameInputs.getPlayerCast());
        this.map = new Map();
    }

    public Map getMap(){
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Panel getPanel() {
        return this.getPanel();
    }
}
