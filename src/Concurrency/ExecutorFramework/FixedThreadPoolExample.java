package Concurrency.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Creating a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Submitting 10 tasks to the executor
        for(int i=0; i<10; i++) {
            Runnable worker = new WorkerThread(" Task " + i);
            executor.execute(worker);
        }
        // Initiating an orderly shutdown
        executor.shutdown();
        try {
            // Waiting for all tasks to complete or timeout after a specified period
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Forcefully shutdown if tasks are not finished
            }

        }catch(InterruptedException ex) {
            executor.shutdownNow();
        }
        System.out.println("All tasks are finished!");
    }
}


 class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "(Start) message = "+ message);
        processMesssage();
        System.out.println(Thread.currentThread().getName() + " (End) ");
    }

    private void processMesssage() {
        try{
            Thread.sleep(200);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
