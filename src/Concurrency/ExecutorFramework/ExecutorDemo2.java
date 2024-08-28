package Concurrency.ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> 2 + 1);
        Integer val = future.get();
        System.out.println(val);
        executorService.shutdown();
        Thread.sleep(1);
        System.out.println(executorService.isTerminated());
    }
}
