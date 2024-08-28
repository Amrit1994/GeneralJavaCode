package Concurrency.RunnableCallable;

public class RunnableFactorialException implements Runnable {
    private int number;
    private long result;

    public RunnableFactorialException(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = factorial(number);
    }

    public long factorial(int num) {
        if(num <= 1) {
            return 1;
        }
        return num * factorial(num-1);
    }
    public long getResult() {
        return result;
    }

    public static void main(String[] args) {
        RunnableFactorialException runnableFactorialException = new RunnableFactorialException(5);
        Thread thread = new Thread(runnableFactorialException);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.err.println("Exception " + e.getMessage());
        }
        System.out.println("Factorial using Runnable: "+ runnableFactorialException.getResult());
    }
}
