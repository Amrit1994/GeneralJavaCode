package Concurrency.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ok1";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ok2";
        });
        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
        //f.join();
        try {
            f.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread");
    }
}
