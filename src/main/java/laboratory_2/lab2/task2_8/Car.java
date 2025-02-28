package laboratory_2.lab2.task2_8;

public class Car {

    private final int number;

    public Car(int number) {
        this.number = number;
    }

    public synchronized void pass(Crossroad crossroad) {
        crossroad.waitForGreen();
        System.out.println("Машина " + number + " проехала перекресток");
    }
}
