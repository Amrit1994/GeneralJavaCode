package Concurrency.Synchronised;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Thread producer1 = new Thread(new Producer(buffer), "Producer-1");
        Thread producer2 = new Thread(new Producer(buffer), "Producer-2");
        Thread consumer1 = new Thread(new Consumer(buffer), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(buffer), "Consumer-2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}

class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int maxSize;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void produce(int value) throws InterruptedException{
        while(queue.size() == maxSize) {
            wait();
        }
        queue.offer(value);
        System.out.println("Produced: " +value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int value = queue.poll();
        System.out.println("Consumed: "+ value);
        notifyAll();
        return value;
    }
}

class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try {
            int i = 0;
            while(true) {
                buffer.produce(i++);
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while(true) {
                buffer.consume();
                Thread.sleep(150);
            }
        }catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

