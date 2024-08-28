package Concurrency.ExecutorFramework;

import java.util.concurrent.*;

public class ExecutorDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(()-> System.out.println("Hello"));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureCallable = executorService.submit(() -> "Callable " +42); // taking callable in param
        Future<?> futureRunnable = executorService.submit(() -> System.out.println("Runnable "+ 42)); // taking Runnable in param
        Future<?> future  = executorService.submit(() -> System.out.println("Runnable complete"), "Success");
        System.out.println(futureCallable.get());
        executorService.shutdown();
    }
}
