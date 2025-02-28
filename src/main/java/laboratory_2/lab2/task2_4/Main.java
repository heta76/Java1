package laboratory_2.lab2.task2_4;

public class Main {
    public static void main(String[] args) {
        GazStation gazStation = new GazStation(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                gazStation.Refuel(finalI + " машина");
            }).start();
            }
    }
}
