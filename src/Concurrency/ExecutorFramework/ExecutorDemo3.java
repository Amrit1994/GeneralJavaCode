package Concurrency.ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDemo3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };
        List<Callable<Integer>> list  = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = executorService.invokeAll(list);
        //List<Future<Integer>> futures = executorService.invokeAll(list, 1, TimeUnit.SECONDS);
        for (Future<Integer> future: futures) {
            System.out.println(future.get());
        }
        executorService.shutdown();
        System.out.println("All Task Completed");

    }
}
