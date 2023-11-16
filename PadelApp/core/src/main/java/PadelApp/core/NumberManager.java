package PadelApp.core;

/**
 * Utility class for managing and extracting information from numbers.
 */
public class NumberManager {
  /**
   * Returns the number of digits in an integer.
   *
   * @param number the integer to count the digits of
   * @return the number of digits in the integer
   */
  public static int getDigits(int number) {
    int digits = 0;
    while (number > 0) {
      number = number / 10;
      digits++;
    }
    return digits;
  }

  /**
   * Returns the number of digits in an Integer.
   *
   * @param number the Integer to count the digits of
   * @return the number of digits in the Integer
   */
  public static int getDigits(Integer number) {
    int digits = 0;
    while (number > 0) {
      number = number / 10;
      digits++;
    }
    return digits;
  }

  /**
   * Returns the first digit of a given integer.
   *
   * @param number the integer to get the first digit from
   * @return the first digit of the given integer
   */
  public static int getFirstDigit(int number) {
    while (number > 9) {
      number /= 10;
    }
    return number;
  }
}