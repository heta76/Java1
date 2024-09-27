package org.knit.lab2;

public class Sphere extends Shape {
    public Sphere(double length) {
        super(length);
    }

    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(length, 3);
    }
}
