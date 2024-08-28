package DesignPattern.Creational.Builder.construction;

public class BuilderPatternExample {
    public static void main(String[] args) {
        CarBuilder sedanBuilder = new SedanCarBuilder();
        CarDirector director = new CarDirector(sedanBuilder);
        Car sedan = director.constructorCar();
        System.out.println(sedan);

        CarBuilder suvBuilder = new SUVCarBuilder();
        director = new CarDirector(suvBuilder);
        Car suv = director.constructorCar();
        System.out.println(suv);
    }
}
