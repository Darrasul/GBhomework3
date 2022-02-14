package lessons.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CarService {

    private final CyclicBarrier awaitBarrier;
    private WaitingNotifier waitingNotifier;

    public CarService(int carCount, WaitingNotifier waitingNotifier, Runnable startAction) {
        this.awaitBarrier = new CyclicBarrier(carCount + 1, startAction);
        this.waitingNotifier = waitingNotifier;
    }

    public Car createCar(Race race, int speed) {
        return new Car(race, speed, awaitBarrier, waitingNotifier);
    }

    public void awaitingToAllCarsStart() {
        try {
            awaitBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
