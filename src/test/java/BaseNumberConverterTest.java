import exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseNumberConverterTest {

  BaseNumberConverter baseNumberConverter = new BaseNumberConverter();

  @Test
  void convertFromBinaryToDecimal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals("170", baseNumberConverter.convertBaseNumber
        ("binary", "decimal", "10101010"));

    assertEquals("170",baseNumberConverter.convertFromBinaryToDecimal
        ("10101010"));
  }

  @Test
  void convertFromBinaryToOctal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals("5252", baseNumberConverter.convertBaseNumber
        ("binary", "octal", "101010101010"));

    assertEquals("5252", baseNumberConverter.convertFromBinaryToOctal
        ("101010101010"));
  }

  @Test
  void convertFromBinaryToHexadecimal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("binary", "hexadecimal", "10101010"), "AA");

    assertEquals(baseNumberConverter.convertFromBinaryToHexadecimal
        ("10101010"), "AA");
  }

  @Test
  void convertFromOctalToBinary_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("octal", "binary", "677"), "110111111");

    assertEquals(baseNumberConverter.convertFromOctalToBinary
        ("677"), "110111111");
  }

  @Test
  void convertFromOctalToDecimal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("octal", "decimal", "76546"), "32102");

    assertEquals(baseNumberConverter.convertFromOctalToDecimal
        ("76546"), "32102");
  }

  @Test
  void convertFromOctalToHexadecimal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("octal", "hexadecimal", "65436"), "6B1E");

    assertEquals(baseNumberConverter.convertFromOctalToHexadecimal
        ("65436"), "6B1E");
  }

  @Test
  void convertFromDecimalToBinary_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("decimal", "binary", "7556"), "1110110000100");

    assertEquals(baseNumberConverter.convertFromDecimalToBinary
        ("7556"), "1110110000100");
  }

  @Test
  void convertFromDecimalToOctal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("decimal", "octal", "75"), "113");

    assertEquals(baseNumberConverter.convertFromDecimalToOctal
        ("75"), "113");
  }

  @Test
  void convertFromDecimalToHexadecimal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("decimal", "hexadecimal", "67865576"), "40B8BE8");

    assertEquals(baseNumberConverter.convertFromDecimalToHexadecimal
        ("67865576"), "40B8BE8");
  }

  @Test
  void convertFromHexadecimalToBinary_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("hexadecimal", "binary", "AB"), "10101011");

    assertEquals(baseNumberConverter.convertFromHexadecimalToBinary
        ("AB"), "10101011");
  }

  @Test
  void convertFromHexadecimalToOctal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("hexadecimal", "octal", "ABCD"), "125715");

    assertEquals(baseNumberConverter.convertFromHexadecimalToOctal
        ("ABCD"), "125715");
  }

  @Test
  void convertFromHexadecimalToDecimal_returns_converted_value() throws BaseValueException, BaseNumberConverterException {
    assertEquals(baseNumberConverter.convertBaseNumber
        ("hexadecimal", "decimal", "ABCDEF"), "11259375");

    assertEquals(baseNumberConverter.convertFromHexadecimalToDecimal
        ("ABCDEF"), "11259375");
  }

  @Test
  void convertFromInvalidFormatToValidFormat_returns_BaseNumberConverterException() {
    Exception exception = assertThrows(BaseNumberConverterException.class, () -> baseNumberConverter.convertBaseNumber
        ("invalid", "decimal", "87657901"));
    assertEquals("The base is invalid. Please select one of these: binary," +
        " octal, decimal or hexadecimal", exception.getMessage());
  }

  @Test
  void convertFromValidFormatToInvalidFormat_returns_BaseNumberConverterException() {
    Exception exception = assertThrows(BaseNumberConverterException.class, () -> baseNumberConverter.convertBaseNumber
        ("binary", "invalid", "87657901"));
    assertEquals("The base is invalid. Please select one of these:" +
        " binary, octal, decimal or hexadecimal", exception.getMessage());
  }

  @Test
  void convertFromBinary_returns_BinaryValueException() {
    Exception exception = assertThrows(BinaryValueException.class, () -> baseNumberConverter.convertBaseNumber
        ("binary", "decimal", "32945"));
    assertEquals("Invalid Binary number format!", exception.getMessage());
  }

  @Test
  void convertFromOctal_returns_OctalValueException() {
    Exception exception = assertThrows(OctalValueException.class, () -> baseNumberConverter.convertBaseNumber
        ("octal", "decimal", "98707"));
    assertEquals("Invalid octal number format!", exception.getMessage());
  }

  @Test
  void convertFromDecimal_returns_DecimalFormatValueException() {
    Exception exception = assertThrows(DecimalValueException.class, () -> baseNumberConverter.convertBaseNumber
        ("decimal", "hexadecimal", "AAABBBCCC"));
    assertEquals("Invalid decimal number format!", exception.getMessage());
  }

  @Test
  void convertFromHexadecimal_returns_HexadecimalValueException() {
    Exception exception = assertThrows(HexadecimalValueException.class, () -> baseNumberConverter.convertBaseNumber
        ("hexadecimal", "decimal", "ZZZDDDEPP"));
    assertEquals("Invalid Hexadecimal number format!", exception.getMessage());
  }
}