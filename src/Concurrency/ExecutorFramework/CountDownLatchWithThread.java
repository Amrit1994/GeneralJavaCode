package Concurrency.ExecutorFramework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchWithThread {
    public static void main(String[] args) throws InterruptedException {
        int numberOfService = 3;
        CountDownLatch latch = new CountDownLatch(numberOfService);
        for(int i=0; i<3; i++) {
            new Thread(new DependentRunnableService(latch)).start();
        }
        //latch.await();
        latch.await(5, TimeUnit.SECONDS);
        System.out.println("All dependent services finished. Starting main service...");
    }
}

class DependentRunnableService implements Runnable {
    private final CountDownLatch latch;

    public DependentRunnableService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " service started..");
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            latch.countDown();
        }
    }
}