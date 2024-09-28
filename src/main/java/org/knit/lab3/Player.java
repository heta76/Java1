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

    public Player(String name) {
        this.name = name;
    }

    protected abstract void increaseHealth(int value);

    protected abstract void decreaseHealth(int value);

    public int getcurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void changeX(int x){
        this.x = x;
    }

    public void changeY(int y){
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getDefence(){
        return defence;
    }

    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

}
