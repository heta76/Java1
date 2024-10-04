package org.knit.lab3;

public class Tank extends Warrior {
    private int additionalDefence;

    public Tank(String name, int maxHealth, int x, int y, int damage, int defence, int attackRadius, int additionalDefence) {
        super(name, maxHealth, x, y, damage, defence, attackRadius);
        this.additionalDefence = additionalDefence;
    }

    @Override
    protected void decreaseHealth(int value) {
        int health = this.getcurrentHealth();
        health = Math.min(health + getDefence() - value + additionalDefence, getMaxHealth());
        this.setCurrentHealth(health);
    }

    @Override
    protected int getDefence() {
        return super.getDefence() + additionalDefence;
    }
}
