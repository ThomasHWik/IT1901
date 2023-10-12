package core;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;

public class Leaderboard extends Scoreboard{
    public Leaderboard() {
        this.filename = "Leaderboard.json";
        this.scorelist = new ArrayList<Player>();
    }

    public void sortLeaderboard(){
        this.scorelist.sort(new PlayerComparator());
    }

    //checks if player is already in the leaderboard, if not, adds it (tlfNr is the unique identifier)
    public void addScoreboard(Scoreboard scoreboard) throws StreamWriteException, IOException {
        for (Player playerScoreboard : scoreboard.getScorelist()) {
            for (Player playerLeaderboard : this.scorelist) {
                if (playerScoreboard.getTlfNr() == playerLeaderboard.getTlfNr()) {
                    playerLeaderboard.addWins(playerScoreboard.getWins());
                }
            }
            this.scorelist.add(playerScoreboard);
        }
        FileManagerJson.saveScoreboard((Scoreboard) this);
    }

    public ArrayList<Player> getTopPlayers(int n) {
        sortLeaderboard();
        if (this.scorelist.size() < n) {
            n = this.scorelist.size();
        }
        ArrayList<Player> topPlayers = new ArrayList<Player>();
        for (int i = 0; i < n; i++) {
            topPlayers.add(this.scorelist.get(i));
        }
        return topPlayers;
    }
}
