package DesignPattern.SOLID.DIP;

public class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
        // or
        device.turnOff();
    }
}
