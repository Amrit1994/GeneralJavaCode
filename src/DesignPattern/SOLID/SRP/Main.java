package DesignPattern.SOLID.SRP;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        BookPrinter printer = new BookPrinter();
        printer.printTextToConsole("Hello Print");
    }


}
