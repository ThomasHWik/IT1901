package PadelApp.core;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;

public class Leaderboard extends Scoreboard{
    public Leaderboard() {
        super("Leaderboard");
    }

    public Leaderboard(String filename) {
        super(filename);
    }

    public void sortLeaderboard(){
        this.getScorelist().sort(new PlayerComparator());
    }

    //checks if player is already in the leaderboard, if not, adds it (tlfNr is the unique identifier)
    public void addScoreboard(Scoreboard scoreboard) throws StreamWriteException, IOException {
        for (Player playerScoreboard : scoreboard.getScorelist()) {
            boolean found = false;
            for (Player playerLeaderboard : this.getScorelist()) {
                if (playerScoreboard.getTlfNr() == playerLeaderboard.getTlfNr()) {
                    playerLeaderboard.addWins(playerScoreboard.getWins());
                    found = true;
                    break;
                }
            }
            if (!found) {
                Player player = new Player(playerScoreboard.getName(), playerScoreboard.getAge(), playerScoreboard.getWins(), playerScoreboard.getTlfNr());
                this.addPlayer(player);
            }
        }
    }
}