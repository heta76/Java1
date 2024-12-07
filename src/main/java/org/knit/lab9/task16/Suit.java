package org.knit.lab9.task16;

public enum Suit {
    DIAMONDS("Бубны"),
    HEARTS("Черви"),
    SPADES("Пики"),
    CLUBS("Трефы");
    private String name;
    Suit(String name) {
    }

    public String getName() {
        return name;
    }
}
