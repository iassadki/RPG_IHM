package game;

import java.awt.*;

public class Game {

    private Map map;

    private Player player;
    private GameInputs gameInputs;

    public Game(GameInputs gameInputs) {
        this.map = new Map();
        this.player = new Player(gameInputs.getPlayerName(), gameInputs.getPlayerCast(), this.map);
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

    public GameInputs getInputs() {
        return this.gameInputs;
    }
}
