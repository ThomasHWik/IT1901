package PadelApp.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameSetupTest {
    private List<PlayerPair> playerPairs= new ArrayList<>();
    private GameSetup gameSetup= new GameSetup(0,playerPairs);
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeEach
    void setUp() {
        // Create a list of player pairs and a game setup object before each test
        player1 = new Player("Lewis", 38, 41414141);
        player2 = new Player("Lando", 23, 92929292);
        player3 = new Player("Logan", 22, 43434343);
        player4 = new Player("Daniel", 34, 94949494);

        playerPairs = new ArrayList<>();
        playerPairs.add(new PlayerPair(player1, player2));
        playerPairs.add(new PlayerPair(player3, player4));
        gameSetup = new GameSetup(1, playerPairs);
    }

    @Test
    void testGetSingle() {
        // Test the getSingle() method
        assertEquals(playerPairs.size() - gameSetup.getDouble() * 2, gameSetup.getSingle());
    }

    @Test
    void testGetDouble() {
        // Test the getDouble() method
        assertEquals(1, gameSetup.getDouble());
    }

    @Test
    void testInvalidSetup() {
        // Test that the constructor throws IllegalArgumentException for invalid setups
        assertThrows(IllegalArgumentException.class, () -> new GameSetup(2, playerPairs));
    }

    @Test
    void testMaxPlayerPairs() {
        Player player = new Player("test", 1, 40000000);
        // Test that the constructor throws IllegalArgumentException when exceeding maxPlayerpairs
        List<PlayerPair> tooManyPlayerPairs = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tooManyPlayerPairs.add(new PlayerPair(player,player));
        }
        assertThrows(IllegalArgumentException.class, () -> new GameSetup(1, tooManyPlayerPairs));
    }
}