import exceptions.BaseNumberConverterException;
import exceptions.BaseValueException;
import exceptions.BinaryValueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseNumberConverter {

  public static boolean isValidBinary(String targetNumber) {
    String regex = "^[0-1]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(targetNumber);
    return matcher.matches();
  }

  public String convertFromBinaryToDecimal(String targetNumber) throws BinaryValueException {

    if (!isValidBinary(targetNumber)) {
      throw new BinaryValueException();
    }

    char[] binary = targetNumber.toCharArray();
    int decimal = 0;

    for (int i = binary.length - 1, j = 0, k; i >= 0; i--, j++) {
      k = (binary[i] == '1') ? 1 : 0;
      decimal += k * Math.pow(2, j);
    }
    return String.valueOf(decimal);
  }


  public String convertFromBinaryToOctal(String targetNumber) throws BinaryValueException {

    if (!isValidBinary(targetNumber)) {
      throw new BinaryValueException();
    }

    char[] binary = targetNumber.toCharArray();
    int binaryElementIndex = binary.length - 1;
    StringBuilder octal = new StringBuilder();
    int targetNumberTrioQuantity = 0;
    int factor = 0;

    targetNumberTrioQuantity = (binary.length % 3 == 0 && binary.length >= 3)
        ? binary.length / 3 : binary.length / 3 + 1; // targetNumber.length() / 3;

    do {
      for (int i = 0, binaryElement = 0; i < 3 && binaryElementIndex >= 0; i++) {
        binaryElement = (binary[binaryElementIndex] == '1') ? 1 : 0;
        factor += (int) (binaryElement * Math.pow(2, i));
        binaryElementIndex--;
      }
      octal.append(factor);
      factor = 0;
      targetNumberTrioQuantity--;
    } while (targetNumberTrioQuantity > 0);

    return String.valueOf(octal.reverse());
  }

  public String convertFromBinaryToHexadecimal(String targetNumber) {

    return "result";
  }

  public static boolean isValidOctal(String targetNumber) {
    String regex = "^[0-8]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(targetNumber);
    return matcher.matches();
  }

  public String convertFromOctalToBinary(String targetNumber) {

    return "result";
  }

  public String convertFromOctalToDecimal(String targetNumber) {

    return "result";
  }

  public String convertFromOctalToHexadecimal(String targetNumber) {

    return "result";
  }

  public static boolean isValidDecimal(String targetNumber) {
    String regex = "^[0-9]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(targetNumber);
    return matcher.matches();
  }

  public String convertFromDecimalToBinary(String targetNumber) {

    return "result";
  }

  public String convertFromDecimalToOctal(String targetNumber) {

    return "result";
  }

  public static boolean isValidHexadecimal(String targetNumber) {
    String regex = "^[A-Fa-f0-9]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(targetNumber);
    return matcher.matches();
  }

  public String convertFromDecimalToHexadecimal(String targetNumber) {

    return "result";
  }

  public String convertFromHexadecimalToBinary(String targetNumber) {

    return "result";
  }

  public String convertFromHexadecimalToOctal(String targetNumber) {

    return "result";
  }

  public String convertFromHexadecimalToDecimal(String targetNumber) {

    return "result";
  }

  public String convertBaseNumber(String baseFrom, String baseTo, String targetNumber)
      throws BaseValueException, BaseNumberConverterException {

    BaseNumberConverter baseNumberConverter = new BaseNumberConverter();
    String convertedResult = null;

    switch (baseFrom) {
      case "binary":
        switch (baseTo) {
          case "octal":
            convertedResult = baseNumberConverter.convertFromBinaryToOctal(targetNumber);
            break;
          case "decimal":
            convertedResult = baseNumberConverter.convertFromBinaryToDecimal(targetNumber);
            break;
          case "hexadecimal":
            convertedResult = baseNumberConverter.convertFromBinaryToHexadecimal(targetNumber);
            break;
          default:
            throw new BaseNumberConverterException();
        }
        break;
      case "decimal":
        switch (baseTo) {
          case "binary":
            convertedResult = baseNumberConverter.convertFromDecimalToBinary(targetNumber);
            break;
          case "octal":
            convertedResult = baseNumberConverter.convertFromDecimalToOctal(targetNumber);
            break;
          case "hexadecimal":
            convertedResult = baseNumberConverter.convertFromDecimalToHexadecimal(targetNumber);
            break;
          default:
            throw new BaseNumberConverterException();
        }
        break;
      case "octal":
        switch (baseTo) {
          case "binary":
            convertedResult = baseNumberConverter.convertFromOctalToBinary(targetNumber);
            break;
          case "decimal":
            convertedResult = baseNumberConverter.convertFromOctalToDecimal(targetNumber);
            break;
          case "hexadecimal":
            convertedResult = baseNumberConverter.convertFromOctalToHexadecimal(targetNumber);
            break;
          default:
            throw new BaseNumberConverterException();
        }
        break;
      case "hexadecimal":
        switch (baseTo) {
          case "binary":
            convertedResult = baseNumberConverter.convertFromHexadecimalToBinary(targetNumber);
            break;
          case "octal":
            convertedResult = baseNumberConverter.convertFromHexadecimalToOctal(targetNumber);
            break;
          case "decimal":
            convertedResult = baseNumberConverter.convertFromHexadecimalToDecimal(targetNumber);
            break;
          default:
            throw new BaseNumberConverterException();
        }
        break;
      default:
        throw new BaseNumberConverterException();
    }
    return convertedResult;
  }

}
