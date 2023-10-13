package PadelApp.core;

import java.io.IOException;
import java.util.ArrayList;
import PadelApp.json.FileManagerJson;

import com.fasterxml.jackson.core.exc.StreamWriteException;

public class Leaderboard extends Scoreboard{
    public Leaderboard() {
        super("Leaderboard.json");
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
                this.getScorelist().add(playerScoreboard);
            }
        }
        FileManagerJson.saveScoreboard((Scoreboard) this);
    }

    public ArrayList<Player> getTopPlayers(int n) {
        sortLeaderboard();
        if (this.getScorelist().size() < n) {
            n = this.getScorelist().size();
        }
        ArrayList<Player> topPlayers = new ArrayList<Player>();
        for (int i = 0; i < n; i++) {
            topPlayers.add(this.getScorelist().get(i));
        }
        return topPlayers;
    }
}
