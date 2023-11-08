package PadelApp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardTest {

    private Leaderboard leaderboard;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeEach
    public void setUp() {
        leaderboard = new Leaderboard("testLeaderboard.json");
        player1 = new Player("John", 2, 5, 91919191);
        player2 = new Player("Jane", 4, 3, 42424242);
        player3 = new Player("Bob", 5, 2, 93939393);
        player4 = new Player("Alice", 3, 4, 44444444);
    }
    /* 
    @Test
    public void testAddScoreboard() throws IOException {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.addPlayer(player1);
        scoreboard.addPlayer(player2);

        leaderboard.addScoreboard(scoreboard);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), leaderboard.getScorelist().get(i));
        }
    }
    */

    /*
    @Test
    public void testSortLeaderboard() {
        leaderboard.addPlayer(player1);
        leaderboard.addPlayer(player2);
        leaderboard.addPlayer(player3);
        leaderboard.addPlayer(player4);

        leaderboard.sortLeaderboard();

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        expected.add(player4);

        expected.sort(new PlayerComparator());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getTlfNr(), leaderboard.getScorelist().get(i).getTlfNr());
        }
    }
    */

    @Test
    public void testGetTopPlayers() {
        leaderboard.addPlayer(player1);
        leaderboard.addPlayer(player2);
        leaderboard.addPlayer(player3);
        leaderboard.addPlayer(player4);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player4);

        List<Player> topPlayers = leaderboard.getTopPlayers(2);
        
        assertEquals(expected.size(), topPlayers.size());
        assertEquals(expected.get(0).getTlfNr(), topPlayers.get(0).getTlfNr());
        assertEquals(expected.get(1).getTlfNr(), topPlayers.get(1).getTlfNr());
    }

    @Test
    public void testGetTopPlayersWithEmptyLeaderboard() {
        ArrayList<Player> expected = new ArrayList<>();

        assertEquals(expected, leaderboard.getTopPlayers(2));
    }
}