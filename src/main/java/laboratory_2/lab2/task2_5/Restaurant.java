package laboratory_2.lab2.task2_5;
import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {

    private final int CAPACITY = 3;
    private final Queue<Integer> mealsQueue = new LinkedList<>();

    public synchronized void cook(int number) {
        while (mealsQueue.size() >= CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mealsQueue.add(number);
        System.out.println("Повар приготовил блюдо " + number);
        notify();
    }

    public synchronized void serve() {
        while (mealsQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Официант подал блюдо " + mealsQueue.poll());
        notify();
    }
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Thread threadCooker = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaurant.cook(i);
            }
        });

        Thread threadWaiter = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                restaurant.serve();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadCooker.start();
        threadWaiter.start();
    }
}
