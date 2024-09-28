package org.knit.lab3;

public class Main {
    public static void main(String[] args) {
        Mage mage = new Mage("mag");
        Warrior warrior = new Warrior("war");
        Priest priest = new Priest(("prst"));
        mage.attack(warrior);
        warrior.attack(mage);
        warrior.attack(mage);
        mage.castSpell();
        priest.heal(warrior);
    }
}
