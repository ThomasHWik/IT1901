package padelapp.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import padelapp.core.Player;
import padelapp.core.Scoreboard;

public class ScoreboardTest {

    private Scoreboard scoreboard;
    private String filename;
    private ArrayList<Player> scorelist;

    @BeforeEach
    public void setUp() {
        ArrayList<Player> playerlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Player player = new Player("Player" + i, 0);
            playerlist.add(player);
        }
        filename = "test";
        this.scorelist = playerlist;
        scoreboard = new Scoreboard(filename, scorelist);
    }
    
    @Test
    public void testGetFilename() {
        assertEquals("test", scoreboard.getFilename());
    }

    @Test
    void testSetFilename() {
        scoreboard.setFilename("test2");
        assertEquals("test2", scoreboard.getFilename());
    }

    @Test
    void testAddPlayer() {
        Player player = new Player("dummie", 0);
        scoreboard.addPlayer(player);
        assertTrue(scoreboard.getScorelist().contains(player));
    }

    @Test
    void testRemovePlayer() {
        Player player = scoreboard.getScorelist().get(0);
        scoreboard.removePlayer(player);
        assertTrue(!scoreboard.getScorelist().contains(player));
    }

    @Test
    void testGetScorelist() {
        ArrayList<Player> newScorelist = scoreboard.getScorelist();
        for (int i = 0; i < scorelist.size(); i++) {
            if (scorelist.get(i) == newScorelist.get(i)) {
                assertTrue(true);
                assertEquals(scorelist.get(i).getName(), newScorelist.get(i).getName());
                assertEquals(scorelist.get(i).getAge(), newScorelist.get(i).getAge());
            }
            assertTrue(!(scorelist == newScorelist));
        }
    }

    @Test
    void testSetScorelist() {
        ArrayList<Player> newScorelist = new ArrayList<>();
        scoreboard.setScorelist(newScorelist);
        assertTrue(scoreboard.getScorelist().isEmpty());
    }
}