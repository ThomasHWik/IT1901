package PadelApp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberManagerTest {
    private int intPhoneNumber;
    private Integer integerPhoneNumber;
    private int expectedDigitCount;

    @BeforeEach
    void setUp() {
        intPhoneNumber = 91827364;
        integerPhoneNumber = 45362718;
        expectedDigitCount = 8;
    }

    @Test
    void testGetDigitsIntNumber() {
        int actualDigitCount = NumberManager.getDigits(intPhoneNumber);
        assertEquals(expectedDigitCount, actualDigitCount);
    }

    @Test
    void testGetDigitsIntegerNumber() {
        int actualDigitCount = NumberManager.getDigits(integerPhoneNumber);
        assertEquals(expectedDigitCount, actualDigitCount);
    }

    @Test
    void testGetFirstDigit() {
        assertEquals(9, NumberManager.getFirstDigit(intPhoneNumber));
    }
}
