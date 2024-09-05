package DesignPattern.Creational.AbstractFactory.ConcreteFactoryClasses;

import DesignPattern.Creational.AbstractFactory.AbstractFactoryInterface.GUIFactory;
import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Button;
import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Checkbox;
import DesignPattern.Creational.AbstractFactory.ConcreteProductClass.WindowsButton;
import DesignPattern.Creational.AbstractFactory.ConcreteProductClass.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
