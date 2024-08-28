package Concurrency;

public class WorldThread extends Thread{
   @Override
    public void run() {
       for (int i=0; i< 100000; i++) {
           System.out.println(Thread.currentThread().getName());
       }
   }
}
