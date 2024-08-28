package Concurrency.ExecutorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        // Schedule a task to run after a 3-second delay
        scheduler.schedule(() -> {
            System.out.println("Task executed after delay.");

        }, 3, TimeUnit.SECONDS);

        // Schedule a task to run repeatedly every 2 seconds with an initial delay of 1 second
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task executed");
        }, 1, 2, TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(() ->
                System.out.println("Task Executed after every 5 seconds"), 5, 5, TimeUnit.SECONDS);

        // Shutdown the scheduler after some time
        scheduler.schedule(() -> {
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
