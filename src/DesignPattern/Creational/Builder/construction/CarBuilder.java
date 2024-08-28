package DesignPattern.Creational.Builder.construction;

public abstract class CarBuilder {
    protected Car car;
    public void createNewCar() {
        car = new Car();
    }

    public Car getCar() {
        return car;
    }

    public abstract void buildEngine();
    public abstract void buildWheels();
    public abstract void buildBody();
}

class SedanCarBuilder extends CarBuilder {

    @Override
    public void buildEngine() {
        car.setEngine("Sedan Engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Sedan wheels");
    }

    @Override
    public void buildBody() {
        car.setBody("Sedan body");
    }
}

class SUVCarBuilder extends CarBuilder {

    @Override
    public void buildEngine() {
        car.setEngine("SUV Engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels("SUV wheels");
    }

    @Override
    public void buildBody() {
        car.setBody("SUV body");
    }
}

class CarDirector {
    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }
    public Car constructorCar() {
        carBuilder.createNewCar();
        carBuilder.buildEngine();
        carBuilder.buildBody();
        carBuilder.buildWheels();
        return carBuilder.getCar();
    }
}