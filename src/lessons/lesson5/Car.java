package lessons.lesson5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private CyclicBarrier cyclicBarrier;
    private WaitingNotifier waitingNotifier;
    private Race race;
    private int speed;
    private String name;
    private static AtomicBoolean isWinner = new AtomicBoolean(false);

    static {
        CARS_COUNT = 0;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public static AtomicBoolean getIsWinner() {
        return isWinner;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, WaitingNotifier waitingNotifier) {
        this.race = race;
        this.speed = speed;
        this.cyclicBarrier = cyclicBarrier;
        this.waitingNotifier = waitingNotifier;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    private void checkWinner() {
        if (!isWinner.getAndSet(true)){
            System.out.println(this.name + " первым завершает гонку");
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        checkWinner();
        waitingNotifier.notifyAboutFinish();
    }
}
