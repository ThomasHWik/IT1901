package app.LogicTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Logic.Player;
import Logic.PlayerPair;

public class PlayerPairTest {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeEach
    void setUp() {
        // Create new players before each test
        player1 = new Player("Lewis", 38, 10101010);
        player2 = new Player("Lando", 23, 20202020);
        player3 = new Player("Logan", 22, 30303030);
        player4 = new Player("Daniel", 34, 40404040);
    }

    @Test
    void testCreatePlayerPairs() {
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        PlayerPair pair1 = new PlayerPair(player1, player2);
        PlayerPair pair2 = new PlayerPair(player3, player4);

        List<PlayerPair> expectedPairs = new ArrayList<>();
        expectedPairs.add(pair1);
        expectedPairs.add(pair2);

        PlayerPair playerPair = new PlayerPair(player1, player2);
        List<PlayerPair> actualPairs = playerPair.createPlayerPairs(players);

        assertEquals(expectedPairs.get(0).getPlayer1(), actualPairs.get(0).getPlayer1());
        assertEquals(expectedPairs.get(0).getPlayer2(), actualPairs.get(0).getPlayer2());

        assertEquals(expectedPairs.get(1).getPlayer1(), actualPairs.get(1).getPlayer1());
        assertEquals(expectedPairs.get(1).getPlayer2(), actualPairs.get(1).getPlayer2());
    }

    @Test
    void testCreatePlayerPairsWithOddNumberOfPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(player1);

        // Should throw an IllegalArgument Exception when attempting to create pairs from an odd number of players
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerPair playerPair = new PlayerPair(player1, player2);
            playerPair.createPlayerPairs(players);
        });
    }

    @Test
    void testGetPlayer1() {
        PlayerPair playerPair = new PlayerPair(player1, player2);
        assertEquals(player1, playerPair.getPlayer1());
    }

    @Test
    void testGetPlayer2() {
        PlayerPair playerPair = new PlayerPair(player1, player2);
        assertEquals(player2, playerPair.getPlayer2());
    }
    
}
