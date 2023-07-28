package exceptions;

public class OctalValueException extends BaseValueException {
  public OctalValueException() {
    super("Invalid Octal number format!");
  }
}
