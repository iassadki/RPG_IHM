package game;

import game.Weapon;

public class Axe extends Weapon {

    // +CONSTANT_NAME: TYPE = value

    private static final double DAMAGE = 10;
    private static final double PRICE = 5;

    public Axe() {
        super("Axe", DAMAGE, PRICE);
    }

}
