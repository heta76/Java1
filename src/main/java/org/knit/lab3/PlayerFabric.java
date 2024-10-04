package org.knit.lab3;

public class PlayerFabric {
    public Warrior createWarrior(String name) {
        return new Warrior(name, 100, 0, 0, 20, 20, 1);
    }

    public Tank createTank(String name) {
        return new Tank(name, 100, 0, 0, 15, 20, 1, 15);
    }

    public Mage createMage(String name) {
        return new Mage(name, 80, 0, 0, 30, 5, 5);
    }

    public Priest createPriest(String name) {
        return new Priest(name, 80, 0, 0, 20, 5, 10);
    }
}
