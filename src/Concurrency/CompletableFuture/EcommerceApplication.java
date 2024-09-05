package Concurrency.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EcommerceApplication {

    public static void main(String[] args) {
        Logger logger = new Logger();
        // Create an ExecutorService with a fixed thread pool to handle async tasks
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Simulated user actions in an e-commerce application
        String[] userActions = {
                "User added item to cart",
                "User placed an order",
                "User logged in",
                "User logged out",
                "User viewed product details"
        };
        // Iterate over each user action and log it asynchronously
        for(String action : userActions) {
            CompletableFuture.runAsync(() -> logger.logAction(action), executor)
                    .thenRun(() -> System.out.println(Thread.currentThread().getName() + " -Log completed for: "+ action));
        }
        // Main thread can continue doing other work without waiting for logging tasks to complete
        System.out.println("Main application continue to run..");
        executor.shutdown();
    }
}

class Logger {
    public void logAction(String action) {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " - Logged action: "+ action);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Logging interrupted");
        }
    }
}