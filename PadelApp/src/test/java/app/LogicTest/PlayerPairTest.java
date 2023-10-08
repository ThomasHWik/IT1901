package app.LogicTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Logic.Player;
import Logic.PlayerPair;

public class PlayerPairTest {
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        // Create a new Player object before each test
        player1 = new Player("Lewis", 38);
        player2 = new Player("Lando", 23);
    }

    @Test
    void testCreatePlayerPairs() {
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(new Player("Logan", 22));
        players.add(new Player("Daniel", 34));

        PlayerPair pair1 = new PlayerPair(player1, player2);
        PlayerPair pair2 = new PlayerPair(players.get(2), players.get(3));

        List<PlayerPair> expectedPairs = new ArrayList<>();
        expectedPairs.add(pair1);
        expectedPairs.add(pair2);

        PlayerPair playerPair = new PlayerPair(player1, player2);
        List<PlayerPair> actualPairs = playerPair.createPlayerPairs(players);

        assertEquals(expectedPairs.size(), actualPairs.size());
        assertTrue(expectedPairs.containsAll(actualPairs));
        assertTrue(actualPairs.containsAll(expectedPairs));
    }

    @Test
    void testCreatePlayerPairsWithOddNumberOfPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(player1);

        // Attempting to create pairs with an odd number of players should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerPair playerPair = new PlayerPair(player1, player2);
            playerPair.createPlayerPairs(players);
        });
    }
    
}
