package GeneralProgram;

public class AgeValidator {
    public void validate(int age) throws InvalidAgeException {
        if(age < 18) {
            throw new InvalidAgeException("Age must be 18 or older");
        }
    }

}

