package Concurrency.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int count = 0;
    private final ReadWriteLock readWriteLock =  new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.readLock();

    public void increment () {
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        }catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }  finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        }  finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();
        Runnable readtask = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
                }
            }
        };

        Runnable writetask = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            }
        };

        Thread writerThread = new Thread(writetask);
        Thread readerThread1 = new Thread(readtask);
        Thread readerThread2 = new Thread(readtask);

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final count: "+ counter.getCount());

    }
}
