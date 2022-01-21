package exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String error) {
        super(error);
    }
}
