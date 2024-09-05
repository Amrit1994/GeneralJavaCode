package DesignPattern.Creational.Prototype;

public class GuiFramework {
    public static void main(String[] args) {
        Button originalButton = new Button("Submit");
        Button clonedButton = originalButton.clone();
        originalButton.render();
        clonedButton.render();

        TextField originalTextField = new TextField("Enter your name");
        TextField clonedTextField = originalTextField.clone();
        originalTextField.render();
        clonedTextField.render();


    }
}
