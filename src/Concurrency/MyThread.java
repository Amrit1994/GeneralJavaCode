package Concurrency;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState()); // NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE/RUNNING
        Thread.sleep(200);
        System.out.println(t1.getState()); // WAITING/TIMED_WAITING
        t1.join(); // main method wait till t1 is terminated
        System.out.println(t1.getState()); // TERMINATED
    }
}
