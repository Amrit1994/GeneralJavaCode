package Concurrency.Synchronised;

public class LambdaExpression {
    public static void main(String[] args) {
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "-" + i);
                }
            }
        };*/
        // Lambda Expression
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        // Runnable task1 = () -> System.out.println("New Task");
        //Thread t2 = new Thread(task1);
        Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName()  + " New Task"));
        t2.start();
        Thread t3 = new Thread(() -> {
            for(int i=0; i<5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);

            }
        });
        t3.start();

    }
}
