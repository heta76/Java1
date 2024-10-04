package org.knit.lab3;

public class Mage extends Player implements SpellCaster {

    public Mage(String name, int maxHealth, int x, int y, int damage, int defence, int attackRadius) {
        super(name, maxHealth, x, y, damage, defence, attackRadius);
    }

    @Override
    public void castSpell(Player player) {
        if (getIsAlive()) {
            if (!player.getIsAlive()) {
                System.out.println("Игрок " + player.getName() + " уже мертв." + "\n");
            } else {
                if (Math.sqrt(Math.pow(player.getX() - getX(), 2) + Math.pow(player.getY() - getY(), 2)) <= getAttackRadius()) {
                    player.decreaseHealth(getDamage());
                    System.out.println("Маг " + getName() + " нанес " + getDamage() + " урона игроку " + player.getName() + "(защита " + player.getDefence() + ")" + ".");
                    if (player.getcurrentHealth() > 0) {
                        System.out.println("Здоровье игрока " + player.getName() + ":" + player.getcurrentHealth() + "\n");
                    } else {
                        player.setAlive(false);
                        System.out.println("Игрок " + player.getName() + " мертв\n");
                    }
                } else {
                    System.out.println("Маг " + getName() + " находится слишком далеко от игрока " + player.getName() + ", чтобы нанести ему урон.");
                }
            }
        } else {
            System.out.println("Ваш герой мертв. Дождитесь воскрешения.");
        }
    }
}
