package Concurrency.ExecutorFramework;

import java.util.concurrent.*;

public class CountDownLatchDemo {
/*    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependentService());
        Future<String> future2 = executorService.submit(new DependentService());
        Future<String> future3 = executorService.submit(new DependentService());
        // here 3 task so we are using get 3 times, if multiple task is there then we use get method multiple time, so this is not correct
        // that's why we use CountDownLatch
        future1.get();
        future2.get();
        future3.get();
        System.out.println("All dependent services finished. Starting main service...");
        executorService.shutdown();
    }*/

    public static void main(String[] args) throws InterruptedException {
        int numberOfService = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfService);
        /*
        * A synchronization aid that allows one or more threads to wait until a set of operations being performed in other
        * threads completes. A CountDownLatch is initialized with a given count. The await methods block until the current
        * count reaches zero due to invocations of the countDown method, after which all waiting threads are released and
        * any subsequent invocations of await return immediately. This is a one-shot phenomenon -- the count cannot be reset.
        * */
        CountDownLatch latch = new CountDownLatch(numberOfService);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();
        System.out.println("All dependent services finished. Starting main service...");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try{
           System.out.println(Thread.currentThread().getName() + " service started..");
           Thread.sleep(2000);
        }finally {
          latch.countDown();
        }
        return "Ok";
    }
}


