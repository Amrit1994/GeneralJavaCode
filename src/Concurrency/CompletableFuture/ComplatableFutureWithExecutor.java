package Concurrency.CompletableFuture;

import java.util.concurrent.*;

public class ComplatableFutureWithExecutor {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> f =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker Thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Ok";
        }, executor).orTimeout(1, TimeUnit.SECONDS).exceptionally(s -> "Timeout occured");
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
