package lessons.lesson5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static lessons.lesson5.MainClass.CARS_COUNT;

public class Tunnel extends Stage {

    Semaphore tunnel = new Semaphore(CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car car) {
        try {
            try {
                System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
                tunnel.tryAcquire(1, TimeUnit.SECONDS);
                System.out.println(car.getName() + " начал этап: " + description);
                Thread.sleep(length / car.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(car.getName() + " закончил этап: " + description);
                tunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
