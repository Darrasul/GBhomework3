package lessons.lesson5;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        WaitingNotifier waitingNotifier = new WaitingNotifier(CARS_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);

        Runnable startAction = () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        CarService carService = new CarService(CARS_COUNT, waitingNotifier, startAction);

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = carService.createCar(race, 20 + (int)(Math.random() * 10));
        }

        for (Car car : cars) {
            executorService.execute(car);
        }

        carService.awaitingToAllCarsStart();
        waitingNotifier.waitForAllCarsFinish();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        executorService.shutdownNow();
    }
}
