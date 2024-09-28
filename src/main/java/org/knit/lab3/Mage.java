package org.knit.lab3;

public class Mage extends Player implements SpellCaster, Attacker {

    public Mage(String name) {
        super(name);
    }

    @Override
    protected void increaseHealth(int value) {
        int health = getcurrentHealth();
        health += value;
        setCurrentHealth(health);
        if (health <= getMaxHealth()) {
            setCurrentHealth(health);
        } else setCurrentHealth(getMaxHealth());
    }

    @Override
    protected void decreaseHealth(int value) {
        int health = getcurrentHealth() + getDefence() - value;
        if (health <= 0){
            setAlive(false);
            System.out.println("Игрок "+ getName()+" мертв.");
        }
        else setCurrentHealth(health);

    }

    @Override
    public void castSpell() {
        increaseHealth(10);
        System.out.println(getName() + " лечит себя ");
        System.out.println("Здоровье игрока " + getName() + ":" + getcurrentHealth() + "\n");

    }

    @Override
    public void attack(Player player) {
        player.decreaseHealth(10);
        System.out.println(getName() + " атакует игрока " + player.getName());
        System.out.println("Здоровье игрока " + player.getName() + ":" + player.getcurrentHealth() + "\n");
    }
}
