package DesignPattern.Creational.Prototype;

public class Button implements UIElement {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public Button clone() {
        return new Button(label);
    }

    @Override
    public void render() {
        System.out.println("Rendering Button with label: " +label);
    }
}
