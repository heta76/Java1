package org.knit.lab3;

public class Priest extends Player implements Healer {


    public Priest(String name, int maxHealth, int x, int y, int damage, int defence, int attackRadius) {
        super(name, maxHealth, x, y, damage, defence, attackRadius);
    }

    @Override
    public void heal(Player player) {
        if (getIsAlive()) {
            if (Math.sqrt(Math.pow(player.getX() - getX(), 2) + Math.pow(player.getY() - getY(), 2)) <= getAttackRadius()) {
                if (!player.getIsAlive()) {
                    player.increaseHealth(-player.getcurrentHealth() + this.getDamage());
                    System.out.println("Священник " + getName() + " возродил игрока " + player.getName() + ".");
                    System.out.println("Здоровье игрока " + player.getName() + ":" + player.getcurrentHealth() + "\n");
                } else {
                    player.increaseHealth(getDamage());
                    System.out.println("Священник " + getName() + " излечил на " + getDamage() + " игрока " + player.getName() + ".");
                    System.out.println("Здоровье игрока " + player.getName() + ":" + player.getcurrentHealth() + "\n");
                }
            } else {
                System.out.println("Священник " + getName() + " находится слишком далеко от игрока " + player.getName() + ", чтобы излечить его.");
            }
        } else {
            System.out.println("Ваш герой мертв. Дождитесь воскрешения.");

            System.out.println(getName() + " лечит игрока " + player.getName());
            System.out.println("Здоровье игрока " + player.getName() + ":" + player.getcurrentHealth() + "\n");
        }
    }
}
