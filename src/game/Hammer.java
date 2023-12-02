package game;

import game.Weapon;

public class Hammer extends Weapon {

    private static final double DAMAGE = 20;
    private static final double PRICE = 10;

    public Hammer() {
        super("Hammer", DAMAGE, PRICE);
    }

}
