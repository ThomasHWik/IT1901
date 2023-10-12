package PadelApp.core;
import PadelApp.core.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        // Create a new Player object before each test
        player = new Player("Charles", 25, 12345678);
    }

    @Test
    void testGetName() {
        assertEquals("Charles", player.getName());
    }

    @Test
    void testSetName() {
        player.setName("Fernando");
        assertEquals("Fernando", player.getName());
        assertThrows(IllegalArgumentException.class, () -> player.setName(null));
    }

    @Test
    void testGetAge() {
        assertEquals(25, player.getAge());
    }

    @Test
    void testSetAge() {
        player.setAge(64);
        assertEquals(64, player.getAge());
        assertThrows(IllegalArgumentException.class, () -> player.setAge(-1));
    }

    @Test
    void testInitialWins() {
        assertEquals(0, player.getWins());
    }

    @Test
    void testAddWins() {
        for (int i = 1; i <= 10; i++) {
            player.addwins();
            assertEquals(i, player.getWins());
        }
    }

    @Test
    void testSetWins() {
        player.setWins(5);
        assertEquals(5, player.getWins());

        // Test setting wins to a negative value, should give an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> player.setWins(-1));
    }

    @Test
    void testGetWins() {
        player.setWins(3);
        assertEquals(3, player.getWins());
    }

    @Test
    void testGetTlfNr() {
        player.setTlfNr(11223344);
        assertEquals(11223344, player.getTlfNr());
    }

    @Test
    void testSetTlfNr() {
        player.setTlfNr(11223344);
        assertEquals(11223344, player.getTlfNr());
        // Should give an IllegalArgumentException when trying to set phone number with wrong format (not 8 digits)
        assertThrows(IllegalArgumentException.class, () -> player.setTlfNr(333));
    }
}
