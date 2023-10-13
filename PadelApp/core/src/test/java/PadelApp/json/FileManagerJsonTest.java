package PadelApp.json;

import org.junit.jupiter.api.Test;
import PadelApp.core.Leaderboard;
import PadelApp.core.Scoreboard;
import PadelApp.core.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

public class FileManagerJsonTest {
    private Leaderboard leaderboard;
    private Scoreboard scoreboard;

    @Test
    public void TestSaveLeaderboard() {
        leaderboard = new Leaderboard("LeaderboardTest.json");
        
        ArrayList<Player> list = new ArrayList<>();

        Player player1 = new Player("Player1", 1, 11111111);
        Player player2 = new Player("Player2", 2, 22222222);
        Player player3 = new Player("Player3", 3, 33333333);
        Player player4 = new Player("Player4", 4, 44444444);

        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);

        list.get(3).setWins(4);
        list.get(2).setWins(3);
        list.get(1).setWins(2);
        list.get(0).setWins(1);


        leaderboard.setScorelist(list);
        
        assertFalse(leaderboard.getScorelist().isEmpty());

        leaderboard.saveScoreboard();

        Leaderboard lb = FileManagerJson.getLeaderboard("LeaderboardTest.json");
        assertEquals(lb.getFilename(), "LeaderboardTest.json");
        
        ArrayList<Player> lblist = lb.getScorelist();
        assertEquals(lblist.size(), 4);

        for (int i = 0; i < lblist.size(); i++) {
            assertEquals(lblist.get(i).getWins(), i+1);
            assertEquals(lblist.get(i).getTlfNr(), (i+1) * 11111111);
            assertEquals(lblist.get(i).getName(), "Player" + String.valueOf(i+1));
            assertEquals(lblist.get(i).getAge(), i+1);
        }
    }

    @Test
    public void testSaveScoreBoard() {
        scoreboard = new Scoreboard("ScoreboardTest.json");
        
        ArrayList<Player> list = new ArrayList<>();

        Player player1 = new Player("Player1", 1, 11111111);
        Player player2 = new Player("Player2", 2, 22222222);
        Player player3 = new Player("Player3", 3, 33333333);
        Player player4 = new Player("Player4", 4, 44444444);

        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);

        list.get(3).setWins(4);
        list.get(2).setWins(3);
        list.get(1).setWins(2);
        list.get(0).setWins(1);


        scoreboard.setScorelist(list);
        
        assertFalse(scoreboard.getScorelist().isEmpty());

        scoreboard.saveScoreboard();

        Scoreboard sb = FileManagerJson.getScoreboard("ScoreboardTest.json");
        assertEquals(sb.getFilename(), "ScoreboardTest.json");
        
        ArrayList<Player> lblist = sb.getScorelist();
        assertEquals(lblist.size(), 4);

        for (int i = 0; i < lblist.size(); i++) {
            assertEquals(lblist.get(i).getWins(), i+1);
            assertEquals(lblist.get(i).getTlfNr(), (i+1) * 11111111);
            assertEquals(lblist.get(i).getName(), "Player" + String.valueOf(i+1));
            assertEquals(lblist.get(i).getAge(), i+1);
        }
    }

}
