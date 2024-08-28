package Concurrency;

public class Test {
    public static void main(String[] args)  { // main thread
        WorldThread world = new WorldThread();
        world.start();
        WorldRunnable runnable = new WorldRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        for(int i=0; i<100000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
