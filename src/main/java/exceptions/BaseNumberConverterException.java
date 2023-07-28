package exceptions;

public class BaseNumberConverterException extends Exception {
  public BaseNumberConverterException() {
    super("The base is invalid. Please select one of these: binary, octal, decimal or hexadecimal");
  }

}
