package Concurrency.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static CompletableFuture<Long> factorial(int number) {
        return CompletableFuture.supplyAsync(() -> {
            long fact = 1;
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }
            return fact;
        });
    }

    public static void main(String[] args) {
        CompletableFuture<Long> future = factorial(5);
        future.thenAccept(result -> {
            System.out.println("Factorial using CompletableFuture: " + result);
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex);
            return null;
        });

        try {
            // Wait for the computation to complete
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
