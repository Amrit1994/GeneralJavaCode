package DesignPattern.SOLID.DIP;

// Dependency Inversion Principle (DIP)
// The Dependency Inversion Principle states that high-level modules should not depend on low-level modules.
// Both should depend on abstractions.
public interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("LightBulb is turn on.");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb is turn off.");
    }
}

class Fan implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("Fan is turn on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is turn off.");
    }
}