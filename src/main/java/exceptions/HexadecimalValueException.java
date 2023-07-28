package exceptions;

public class HexadecimalValueException extends BaseValueException {

  public HexadecimalValueException() {
    super("Invalid Hexadecimal number format!");
  }
}
