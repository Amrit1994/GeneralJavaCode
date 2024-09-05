package DesignPattern.Creational.AbstractFactory.ConcreteProductClass;

import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Button;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS button.");
    }
}
