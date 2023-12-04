package game;

import ui.Panels.MapPanel;

import java.util.ArrayList;

public class Player {

    private String name;
    private PlayerCast cast;
    private ArrayList<Weapon> weapons;
    private int life;
    private double money;
    private int playerRow;
    private int playerCol;
    private char nextCell;
    private Map map;
    private MapPanel mapPanel;

    public void setMapPanel(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    public Player(String name, PlayerCast cast, Map map) {
        this.name = name;
        this.cast = cast;
        this.money = 50;
        this.life = 100;
        this.weapons = new ArrayList<Weapon>();
        this.map = map;  // Ajout de cette ligne pour initialiser la carte
        this.playerRow = 0;  // Ajout de cette ligne pour initialiser la position du joueur
        this.playerCol = 0;  // Ajout de cette ligne pour initialiser la position du joueur
        this.map.setPlayerPosition(playerRow, playerCol, 0);  // Ajout de cette ligne pour définir la position initiale du joueur sur la carte
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public PlayerCast getCast() {
        return this.cast;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public int[] move(Direction direction) {
        int newRow = this.playerRow;
        int newCol = this.playerCol;

        switch (direction) {
            case UP:
                newRow = Math.max(0, newRow - 1);
                break;
            case DOWN:
                newRow = Math.min(map.getNumRows() - 1, newRow + 1);
                break;
            case RIGHT:
                newCol = Math.min(map.getNumCols() - 1, newCol + 1);
                break;
            case LEFT:
                newCol = Math.max(0, newCol - 1);
                break;
        }

        // Vérifier si la nouvelle position est valide
        if (map.isValidPosition(newRow, newCol)) {
            map.setPlayerPosition(playerRow, playerCol, 0);  // Clear the current position
            map.setPlayerPosition(newRow, newCol, 2);  // Set the new position
            playerRow = newRow;
            playerCol = newCol;
            return new int[]{playerRow, playerCol};
        }

        // Si la nouvelle position n'est pas valide, retourner les coordonnées actuelles
        return new int[]{playerRow, playerCol};
    }

    public void addWeapon(Weapon w) {
        // Ajouter une arme dans l'inventaire de Player
        this.weapons.add(w);
        System.out.println("Vous avez choisi " + w.getName());
    }

    public void buyWeapon(Weapon w) {
        // Choix d'une arme dans le magasin d'armes, avec les chiffres du clavier
        // Ajout de l'arme dans l'inventaire du joueur
        // Retrait de l'argent du joueur
        if (this.money >= w.getPrice()) {
            this.weapons.add(w);
            this.money -= w.getPrice();
        } else {
            System.out.println("You don't have enough money to buy this weapon.");
        }
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}