package org.knit.lab9.task14;

public enum TrafficLight {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");
    private String nextLight;

    TrafficLight(String nextLight) {
        this.nextLight = nextLight;
    }

    public String getNextLight() {
        return nextLight;
    }
}
