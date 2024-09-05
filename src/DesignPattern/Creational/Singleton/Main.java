package DesignPattern.Creational.Singleton;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        //Singleton singleton3 = singleton1.clone();
        singleton1.showMessage();
        System.out.println(singleton1 == singleton2);
    }
}
