package PadelApp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;

import java.io.IOException;
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
        player1 = new Player("John", 22, 5, 98786564);
        player2 = new Player("Jane", 44, 3, 42635442);
        player3 = new Player("Bob", 55, 2, 97363634);
        player4 = new Player("Alice", 33, 4, 98345643);
    }
    
   
    @Test
    void testSortLeaderboard() {
        leaderboard.addPlayer(player1);
        leaderboard.addPlayer(player2);
        leaderboard.addPlayer(player3);
        leaderboard.addPlayer(player4);

        // Sort the leaderboard
        leaderboard.sortLeaderboard();
        

        // Get the sorted player list
        List<Player> sortedPlayers = leaderboard.getTopPlayers(4);

        // Check that the players are sorted in descending order of wins
        assertEquals(5, sortedPlayers.get(0).getWins()); 
        assertEquals(4, sortedPlayers.get(1).getWins());
        assertEquals(3, sortedPlayers.get(2).getWins()); 
        assertEquals(2, sortedPlayers.get(3).getWins()); 
    }

    @Test
    void testAddScoreboard() throws StreamWriteException, IOException {
        // Create a scoreboard with unsorted scores
        Scoreboard scoreboard = new Scoreboard();
    
        scoreboard.addPlayer(player1);
        scoreboard.addPlayer(player2);
        scoreboard.addPlayer(player3);
        scoreboard.addPlayer(player4);

        // Add the scoreboard to the leaderboard
        leaderboard.addScoreboard(scoreboard);

        // Sort the leaderboard
        leaderboard.sortLeaderboard();

        // Get the sorted player list
        List<Player> sortedPlayers = leaderboard.getTopPlayers(4);

        // Check that the players are sorted in descending order of wins
        assertEquals(5, sortedPlayers.get(0).getWins()); 
        assertEquals(4, sortedPlayers.get(1).getWins()); 
        assertEquals(3, sortedPlayers.get(2).getWins());
        assertEquals(2, sortedPlayers.get(3).getWins());
    }

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