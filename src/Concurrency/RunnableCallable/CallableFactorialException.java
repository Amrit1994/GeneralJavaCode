package Concurrency.RunnableCallable;

import java.util.concurrent.*;

public class CallableFactorialException implements Callable<Long> {
    private int number;

    public CallableFactorialException(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        Thread.sleep(100);
        return factorial(number);
    }

    private Long factorial(int n) {
        if (n <= 1) {
            return (long) 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        CallableFactorialException callable = new CallableFactorialException(4);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(callable);
        try {
            Long result = future.get(); // Blocking call, waits for the computation to complete
            System.out.println("Factorial using Callable: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
