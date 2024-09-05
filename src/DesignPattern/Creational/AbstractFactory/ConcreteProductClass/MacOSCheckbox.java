package DesignPattern.Creational.AbstractFactory.ConcreteProductClass;

import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Checkbox;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS checkbox.");
    }
}
