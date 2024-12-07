package org.knit.lab9.task16;

public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    RIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    ACE("Ace"),
    KING("King"),
    QUEEN("Queen"),
    JACK("Jack");
    private String name;

    Rank(String name) {
    }

    public String getName() {
        return name;
    }
}
