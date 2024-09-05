package DesignPattern.Creational.AbstractFactory;

import DesignPattern.Creational.AbstractFactory.AbstractFactoryInterface.GUIFactory;
import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Button;
import DesignPattern.Creational.AbstractFactory.AbstractProductInterface.Checkbox;
import DesignPattern.Creational.AbstractFactory.ConcreteFactoryClasses.MacOSFactory;
import DesignPattern.Creational.AbstractFactory.ConcreteFactoryClasses.WindowsFactory;

//1.Abstract Product Interface 2. Concrete Product class 3. Abstract Factory Interface 4. Concrete Factory classes.
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory guiFactory) {
        this.button = guiFactory.createButton();
        this.checkbox = guiFactory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }
        Application application = new Application(factory);
        application.paint();
    }
}
