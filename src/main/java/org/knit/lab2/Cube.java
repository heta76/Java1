package org.knit.lab2;

public class Cube extends Shape {
    public Cube(double length) {
        super(length);
    }

    public double getVolume() {
        return Math.pow(length, 3);
    }
}
