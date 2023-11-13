package PadelApp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundSelectorTest {
    private RoundSelector roundSelector;

    @BeforeEach
    void setUp() {
        // Create a new RoundSelector with 5 number of rounds before each test
        roundSelector = new RoundSelector(5);
    }

    @Test
    void testRoundSelector() {
        assertEquals(5, roundSelector.getNumberOfRounds());
    }

    @Test
    void testGetNumberOfRounds() {
        assertEquals(5, roundSelector.getNumberOfRounds());
    }

    @Test
    void testSetNumberOfRounds() {
        roundSelector.setNumberOfRounds(7);
        assertEquals(7, roundSelector.getNumberOfRounds());

        // Should throw an IllegalArgumentException when trying to set number
        // of rounds to 0, a negative number or higher than 10
        assertThrows(IllegalArgumentException.class, () -> roundSelector.setNumberOfRounds(0));
        assertThrows(IllegalArgumentException.class, () -> roundSelector.setNumberOfRounds(-3));
        assertThrows(IllegalArgumentException.class, () -> roundSelector.setNumberOfRounds(11));
    }

}
