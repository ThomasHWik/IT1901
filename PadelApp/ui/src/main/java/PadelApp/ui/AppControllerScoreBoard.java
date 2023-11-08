package PadelApp.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import PadelApp.json.FileManagerJson;
import PadelApp.core.Leaderboard;
import PadelApp.core.Player;
import PadelApp.core.Scoreboard;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * This class represents the controller for the scoreboard view of the PadelApp.
 * It initializes the leaderboard and populates the table with the top 10 players.
 * It also provides methods to create a leaderboard and set the scoreboard for a list of players.
 * The class uses FileManagerJson to read and write data to JSON files.
 */
public class AppControllerScoreBoard {

    private Leaderboard leaderboard;
    private Scoreboard scoreboard;

    @FXML
    ListView<String> name;

    @FXML
    ListView<Integer> wins;

    /**
     * Initializes the AppControllerScoreBoard by loading the leaderboard from a JSON file using FileManagerJson.getLeaderboard method.
     * If the leaderboard is null, a new Leaderboard object is created.
     * Calls createLeaderboard method to create the leaderboard UI and populateTable method to populate the table with data.
     * @throws IOException if there is an error reading the JSON file.
     */
    @FXML
    public void initialize() throws IOException {
        leaderboard = FileManagerJson.getLeaderboard("Leaderboard");
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        createLeaderboard();
        populateTable();
    }

    /**
     * Adds the current game's scoreboard to the leaderboard, sorts it, and saves it to a file.
     * @throws IOException if there is an error reading or writing the file.
     */
    public void createLeaderboard() throws IOException {
        leaderboard.addScoreboard(FileManagerJson.getScoreboard("currentgame"));
        leaderboard.sortLeaderboard();
        FileManagerJson.saveScoreboard(leaderboard);
    }

    /**
     * Sets the scoreboard with the given list of players.
     * 
     * @param playerlist the list of players to set the scoreboard with
     */
    public void setScoreboard(List<Player> playerlist) {
        scoreboard = new Scoreboard((ArrayList<Player>) playerlist);
    }

    /**
     * Populates the table with the top 10 players in the leaderboard.
     * Clears the name and wins items before adding the new data.
     */
    private void populateTable() {
        name.getItems().clear();
        wins.getItems().clear();
        for (Player player : leaderboard.getTopPlayers(10)) {
            name.getItems().add(player.getName());
            wins.getItems().add(player.getWins());
        }
    }
}