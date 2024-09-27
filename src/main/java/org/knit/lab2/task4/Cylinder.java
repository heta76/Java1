package org.knit.lab2.task4;

public class Cylinder extends Shape {
    public Cylinder(double length, double high) {
        super(length, high);
    }

    public double getVolume() {
        return Math.PI * Math.pow(length, 2) * high;
    }
}
