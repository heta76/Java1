package org.knit.lab3;

public class Warrior extends Player implements Attacker{


    public Warrior(String name) {
        super(name);
    }

    @Override
    protected void increaseHealth(int value) {
        int health = getcurrentHealth();
        health += value;
        if (health <= getMaxHealth()){
            setCurrentHealth(health);
        }else setCurrentHealth(getMaxHealth());

    }

    @Override
    protected void decreaseHealth(int value) {
        int health = getcurrentHealth();
        health -= value;
        setCurrentHealth(health);
    }


    @Override
    public void attack(Player player) {
        player.decreaseHealth(50);
        System.out.println(getName() + " атакует игрока " + player.getName());
        System.out.println("Здоровье игрока " + player.getName() + ":" + player.getcurrentHealth() + "\n");
    }
}
