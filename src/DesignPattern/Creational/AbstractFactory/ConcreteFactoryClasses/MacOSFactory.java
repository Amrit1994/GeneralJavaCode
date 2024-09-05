package DesignPattern.Creational.AbstractFactory.ConcreteFactoryClasses;

import DesignPattern.Creational.AbstractFactory.AbstractFactoryInterface.GUIFactory;
import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Button;
import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Checkbox;
import DesignPattern.Creational.AbstractFactory.ConcreteProductClass.MacOSButton;
import DesignPattern.Creational.AbstractFactory.ConcreteProductClass.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
