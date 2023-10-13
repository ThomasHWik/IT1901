package PadelApp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeaderboardTest {
    @Test
    public void testAddScoreboard() {
        Leaderboard leaderboard = new Leaderboard();
        Scoreboard scoreboard = new Scoreboard();
        leaderboard.addScoreboard(scoreboard);
        assertEquals(1, leaderboard.getScoreboards().size());
    }
}
