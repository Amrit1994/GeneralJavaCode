package DesignPattern.Creational.AbstractFactory.AbstractFactoryInterface;

import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Button;
import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
