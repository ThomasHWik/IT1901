package app.LogicTest;
import Logic.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        // Create a new Player object before each test
        player = new Player("Charles", 25);
    }

    @Test
    void testGetName() {
        assertEquals("Charles", player.getName());
    }

    @Test
    void testGetAge() {
        assertEquals(25, player.getAge())
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

        // Test setting wins to a negative value
        // player.setWins(-1);
        // assertEquals(0, player.getWins());
    }
}
