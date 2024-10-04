package org.knit.lab3;

import java.net.SocketOption;

public class Main {
    public static void main(String[] args) {
        PlayerFabric fabric = new PlayerFabric();
        Mage mage = fabric.createMage("mag");
        Warrior warrior = fabric.createWarrior("war");
        Tank tank = fabric.createTank("tank");
        Priest priest = fabric.createPriest("prst");
        mage.move(13,11);
        warrior.move(12,11);
        mage.castSpell(warrior);
        warrior.attack(mage);
        warrior.attack(mage);
        mage.castSpell(warrior);
        priest.heal(mage);
        priest.move(11, 10);
        priest.heal(mage);
        System.out.println(tank);
    }
}
