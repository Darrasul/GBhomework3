package lessons.lesson5;

import java.util.concurrent.CountDownLatch;

public class WaitingNotifier {

    private final CountDownLatch countDownLatch;

    public WaitingNotifier(int carsCount) {
        this.countDownLatch = new CountDownLatch(carsCount);
    }

    public void waitForAllCarsFinish() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void notifyAboutFinish() {
        countDownLatch.countDown();
    }
}
