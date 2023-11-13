package padelapp.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import padelapp.core.GameSetup;
import padelapp.core.Player;
import padelapp.core.PlayerPair;

public class GameSetupTest {
    private List<PlayerPair> playerPairs= new ArrayList<>();
    private GameSetup gameSetup= new GameSetup(0,playerPairs);

    @BeforeEach
    void setUp() {
        // Create a list of player pairs and a game setup object before each test
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

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
        Player player = new Player();
        // Test that the constructor throws IllegalArgumentException when exceeding maxPlayerpairs
        List<PlayerPair> tooManyPlayerPairs = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tooManyPlayerPairs.add(new PlayerPair(player,player));
        }
        assertThrows(IllegalArgumentException.class, () -> new GameSetup(1, tooManyPlayerPairs));
    }
}
