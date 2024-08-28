package DesignPattern.Creational.Builder.chaining;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setFirstName("Amrit")
                .setLastName("Jha")
                .setAge(29)
                .setEmail("jhaamrit.nr@gmail.com")
                .setPhone("9871427578")
                .build();
        System.out.println(user);
    }
}
