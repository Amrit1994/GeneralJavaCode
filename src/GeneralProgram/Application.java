package GeneralProgram;

public class Application {
    public static void main(String[] args) {
        AgeValidator ageValidator = new AgeValidator();
        try {
            ageValidator.validate(17);
        } catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        }
    }
}
