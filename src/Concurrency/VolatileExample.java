package Concurrency;

public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj = new SharedObj();
        Thread writerThread = new Thread(() -> {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedObj.setFlagTrue();
        });
        Thread readerThread = new Thread(sharedObj :: printIfFlagTrue);
        writerThread.start();
        readerThread.start();
    }


}

class SharedObj {
    // Here, the flag variable is declared as volatile. When Thread 1 updates flag to true,
    // Thread 2 will immediately see this change because flag is volatile. Without volatile,
    // Thread 2 might never see the change because of potential caching.
    // Every thread has its own cache and updating the value its happened in main m/m, reader thread see the flag everytime false
    // because its reading from cache, using volatile keyword instructing all thread to directly read from main m/m. Volatile is used for
    // only reading flag or giving the info about thread state change, Atomicity or increment and decrement operation you can't achieve here.
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Writer thread made the flag true !");
        flag = true;
    }

    public void printIfFlagTrue() {
        while (!flag) {
            // do nothing
        }
        System.out.println("Flag is true !");
    }
}

