package DesignPattern.Creational.Prototype;

public interface UIElement extends Cloneable{
    UIElement clone();
    void render();
}

