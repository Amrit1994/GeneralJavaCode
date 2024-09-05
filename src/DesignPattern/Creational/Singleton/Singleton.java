package DesignPattern.Creational.Singleton;

public class Singleton implements Cloneable {
    private static volatile Singleton singleton;

    private Singleton() {
    }
    public Singleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static Singleton getInstance() {
        if(singleton == null) { // First check
            synchronized (Singleton.class) {
                if (singleton == null) { // Double check
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void showMessage() {
        System.out.println("Hello, this is a Singleton instance!");
    }
}
