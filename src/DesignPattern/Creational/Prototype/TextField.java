package DesignPattern.Creational.Prototype;

public class TextField implements UIElement{
    private String text;

    public TextField(String text) {
        this.text = text;
    }

    @Override
    public TextField clone() {
        return new TextField(text);
    }

    @Override
    public void render() {
        System.out.println("Rendering TextField with text: "+ text);
    }
}
