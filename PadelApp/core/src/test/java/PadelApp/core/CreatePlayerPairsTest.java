package PadelApp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CreatePlayerPairsTest {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private List<Player> players;

    @BeforeEach
    void setUp() {
        // Create new players before each test
        player1 = new Player("Lewis", 38, 41414141);
        player2 = new Player("Lando", 23, 92929292);
        player3 = new Player("Logan", 22, 43434343);
        player4 = new Player("Daniel", 34, 94949494);

        // Add players to a list and initialize createPlayerPairs
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    /**@Test
    // Tests the getPlayerPairs method, as well as whether the createPlayerPairs methods work
    void testGetPlayerPairs() {
        CreatePlayerPairs createPlayerPairs = new CreatePlayerPairs(players);
        List<PlayerPair> expectedPairs = new ArrayList<>();
        PlayerPair pair1 = new PlayerPair(player1, player2);
        PlayerPair pair2 = new PlayerPair(player3, player4);
        expectedPairs.add(pair1);
        expectedPairs.add(pair2);
        List<PlayerPair> actualPairs = createPlayerPairs.getPlayerPairs();


        assertEquals(expectedPairs.get(0).getPlayer1(), actualPairs.get(0).getPlayer1());
        assertEquals(expectedPairs.get(0).getPlayer2(), actualPairs.get(0).getPlayer2());

        assertEquals(expectedPairs.get(1).getPlayer1(), actualPairs.get(1).getPlayer1());
        assertEquals(expectedPairs.get(1).getPlayer2(), actualPairs.get(1).getPlayer2());
    }
    */
    @Test
    void testCreatePlayerPairsWithOddNumberOfPlayers() {
        List<Player> oddNumberedPlayers = new ArrayList<>();
        oddNumberedPlayers.add(player1);
        oddNumberedPlayers.add(player2);
        oddNumberedPlayers.add(player3);
        // Should throw an IllegalArgument Exception when attempting to create pairs from an odd number of players
        assertThrows(IllegalArgumentException.class, () -> new CreatePlayerPairs(oddNumberedPlayers));
    }
}
