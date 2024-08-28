package DesignPattern.SOLID.LSP;

// Liskov substitution principle
// Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program
public abstract class Bird {
    public abstract void move();
}

class FlyingBird extends Bird {

    @Override
    public void move() {
        fly();
    }
    public void fly() {

    }
}

class Ostrich extends Bird {

    @Override
    public void move() {
        fly();
    }
    public void fly() {

    }
}
