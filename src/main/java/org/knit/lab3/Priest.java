package org.knit.lab3;

public class Priest extends Player implements Healer {
    public Priest(String name) {
        super(name);
    }

    @Override
    protected void increaseHealth(int value) {
        int health = getcurrentHealth();
        health += value;
        setCurrentHealth(health);
    }

    @Override
    protected void decreaseHealth(int value) {
        int health = getcurrentHealth();
        health -= value;
        setCurrentHealth(health);
    }

    @Override
    public void heal(Player player) {
        player.increaseHealth(30);
        System.out.println(getName() + " лечит игрока " + player.getName());
        System.out.println("Здоровье игрока " + player.getName() + ":" + player.getcurrentHealth() + "\n");
    }
}
