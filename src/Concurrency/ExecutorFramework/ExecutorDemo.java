package Concurrency.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        /*
         Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
         At any point, at most nThreads threads will be active processing tasks.
         If additional tasks are submitted when all threads are active,
         they will wait in the queue until a thread is available.
         If any thread terminates due to a failure during execution prior to shutdown,
         a new one will take its place if needed to execute subsequent tasks.
         The threads in the pool will exist until it is explicitly
         */
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1; i<=10; i++) {
            int finalI = i;
            executor.submit(()-> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }
        /*
        * Initiates an orderly shutdown in which previously submitted tasks are executed,
        * but no new tasks will be accepted. Invocation has no additional effect if already shut down.
        * This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that
        * */
        executor.shutdown();
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Time taken:  "+ (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        long result = 1;
        for(int i= 1; i<=n; i++) {
            result *= i;
        }
        return result;
    }
}
