package game;

public class GameInputs {

    private String playerName;
    private PlayerCast playerCast;
    private String selectedWeapon;  // Nouveau champ pour stocker l'arme sélectionnée

    public GameInputs() {
        this.playerName = "";
        this.playerCast = null;
        this.selectedWeapon = "";
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public PlayerCast getPlayerCast() {
        return this.playerCast;
    }

    public String getSelectedWeapon() {
        return this.selectedWeapon;
    }

    public void setPlayerName(String n) {
        this.playerName = n;
    }

    public void setPlayerCast(PlayerCast c) {
        this.playerCast = c;
    }

    public void setSelectedWeapon(String weapon) {
        this.selectedWeapon = weapon;
    }
}
