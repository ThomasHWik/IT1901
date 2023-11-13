package padelapp.json;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import padelapp.core.Leaderboard;
import padelapp.core.Scoreboard;
import padelapp.core.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

public class FileManagerJsonTest {
    private Leaderboard leaderboard;
    private Scoreboard scoreboard;
    private ArrayList<Player> list;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();

        player1 = new Player("Player1", 1, 44444444);
        player2 = new Player("Player2", 2, 99999999);
        player3 = new Player("Player3", 3, 49494949);
        player4 = new Player("Player4", 4, 94949494);

        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);

        list.get(3).setWins(4);
        list.get(2).setWins(3);
        list.get(1).setWins(2);
        list.get(0).setWins(1);
    }

    @Test
    public void TestSaveLeaderboard() {
        leaderboard = new Leaderboard("LeaderboardTest.json");

        leaderboard.setScorelist(list);

        assertFalse(leaderboard.getScorelist().isEmpty());

        leaderboard.saveScoreboard();

        Leaderboard lb = FileManagerJson.getLeaderboard("LeaderboardTest.json");
        assertEquals(lb.getFilename(), "LeaderboardTest.json");

        ArrayList<Player> lblist = lb.getScorelist();
        assertEquals(lblist.size(), 4);

        assertEquals(lblist.get(0).getWins(), 1);
        assertEquals(lblist.get(0).getTlfNr(), 44444444);
        assertEquals(lblist.get(0).getName(), "Player1");
        assertEquals(lblist.get(0).getAge(), 1);

        assertEquals(lblist.get(1).getWins(), 2);
        assertEquals(lblist.get(1).getTlfNr(), 99999999);
        assertEquals(lblist.get(1).getName(), "Player2");
        assertEquals(lblist.get(1).getAge(), 2);

        assertEquals(lblist.get(2).getWins(), 3);
        assertEquals(lblist.get(2).getTlfNr(), 49494949);
        assertEquals(lblist.get(2).getName(), "Player3");
        assertEquals(lblist.get(2).getAge(), 3);

        assertEquals(lblist.get(3).getWins(), 4);
        assertEquals(lblist.get(3).getTlfNr(), 94949494);
        assertEquals(lblist.get(3).getName(), "Player4");
        assertEquals(lblist.get(3).getAge(), 4);
    }

    @Test
    public void testSaveScoreBoard() {
        scoreboard = new Scoreboard("ScoreboardTest.json");

        scoreboard.setScorelist(list);

        assertFalse(scoreboard.getScorelist().isEmpty());

        scoreboard.saveScoreboard();

        Scoreboard sb = FileManagerJson.getScoreboard("ScoreboardTest.json");
        assertEquals(sb.getFilename(), "ScoreboardTest.json");

        ArrayList<Player> lblist = sb.getScorelist();
        assertEquals(lblist.size(), 4);

        assertEquals(lblist.get(0).getWins(), 1);
        assertEquals(lblist.get(0).getTlfNr(), 44444444);
        assertEquals(lblist.get(0).getName(), "Player1");
        assertEquals(lblist.get(0).getAge(), 1);

        assertEquals(lblist.get(1).getWins(), 2);
        assertEquals(lblist.get(1).getTlfNr(), 99999999);
        assertEquals(lblist.get(1).getName(), "Player2");
        assertEquals(lblist.get(1).getAge(), 2);

        assertEquals(lblist.get(2).getWins(), 3);
        assertEquals(lblist.get(2).getTlfNr(), 49494949);
        assertEquals(lblist.get(2).getName(), "Player3");
        assertEquals(lblist.get(2).getAge(), 3);

        assertEquals(lblist.get(3).getWins(), 4);
        assertEquals(lblist.get(3).getTlfNr(), 94949494);
        assertEquals(lblist.get(3).getName(), "Player4");
        assertEquals(lblist.get(3).getAge(), 4);
    }

}
