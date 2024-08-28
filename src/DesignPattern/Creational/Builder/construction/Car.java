package DesignPattern.Creational.Builder.construction;

public class Car {
    private String engine;
    private String wheels;
    private String body;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels='" + wheels + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
