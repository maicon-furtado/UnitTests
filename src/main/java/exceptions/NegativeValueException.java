package exceptions;

public class NegativeValueException extends Exception {
    public NegativeValueException() {
        super("Negative values are not accepted!");
    }
}
