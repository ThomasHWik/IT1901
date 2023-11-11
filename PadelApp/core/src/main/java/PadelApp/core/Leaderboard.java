package PadelApp.core;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;

public class Leaderboard extends Scoreboard{
    public Leaderboard() {
        super("Leaderboard");
    }

    /**
     * Constructs a new Leaderboard object with the specified filename.
     *
     * @param filename the name of the file to read/write leaderboard data from/to
     */
    public Leaderboard(String filename) {
        super(filename);
    }

    /**
     * Sorts the scorelist of the leaderboard using the PlayerComparator.
     */
    public void sortLeaderboard(){
        this.getScorelist().sort(new PlayerComparator());
    }

    /**
     * Adds a scoreboard to the leaderboard. If a player in the scoreboard already exists in the leaderboard,
     * their wins are added to the existing player's wins. If a player in the scoreboard does not exist in the leaderboard,
     * a new player is created and added to the leaderboard. Unique identifier is players tlfNr.
     *
     * @param scoreboard the scoreboard to add to the leaderboard
     * @throws StreamWriteException if there is an error writing to the stream
     * @throws IOException if there is an error with input/output operations
     */
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