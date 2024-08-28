package Concurrency.ExecutorFramework;
// Manually creating Thread array and handling everything
public class BeforeExecutor {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            threads[i-1]  = new Thread(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
            threads[i-1].start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
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
