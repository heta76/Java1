package org.knit.lab3;

public abstract class Player {
    private String name;
    private int currentHealth = 100;
    private int maxHealth = 100;
    private boolean isAlive = true;
    private int x;
    private int y;
    private int damage;
    private int defence;
    private int attackRadius;

    public Player(
            String name,
            int maxHealth,
            int x,
            int y,
            int damage,
            int defence,
            int attackRadius
    ) {
        this.name = name;
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.defence = defence;
        this.attackRadius = attackRadius;
    }

    protected void increaseHealth(int value){
        currentHealth = Math.min((currentHealth + value), maxHealth);
    }

    protected void decreaseHealth(int value){
        currentHealth = Math.min(currentHealth + defence - value, maxHealth);
    };

    public int getcurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void move(int newx, int newy) {
        this.x = newx;
        this.y = newy;
    }

    protected String getName() {
        return name;
    }

    protected int getMaxHealth() {
        return maxHealth;
    }

    protected int getDefence() {
        return defence;
    }

    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

    protected int getDamage() {
        return damage;
    }

    protected int getAttackRadius(){
        return attackRadius;
    }

    @Override
    public String toString() {
        return "Игрок " + name + " : " +
                currentHealth + " hp at " +
                "(" + x + "," + y + ") " +
                "with " + damage + " damage " +
                "and " + defence + " defence";
    }
}
