package exceptions;

public class ZeroOrNegativeValueException extends Exception {
    public ZeroOrNegativeValueException() {
        super("Zero or negative values are not accepted!");
    }
}
