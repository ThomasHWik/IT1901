package PadelApp.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import PadelApp.core.Leaderboard;
import PadelApp.core.Player;
import PadelApp.core.Scoreboard;
import PadelApp.json.FileManagerJson;
import javafx.scene.control.ListView;

/**
 * This class represents the controller for the scoreboard view of the PadelApp.
 * It initializes the leaderboard and populates the table with the top 10
 * players.
 * It also provides methods to create a leaderboard and set the scoreboard for a
 * list of players.
 * The class uses FileManagerJson to read and write data to JSON files.
 */
public class AppControllerScoreBoard {

  private Leaderboard leaderboard;
  private Scoreboard scoreboard;

  @FXML
  private ListView<String> lbName, sbName;

  @FXML
  private ListView<Integer> lbWins, sbWins;

  /**
   * Initializes the AppControllerScoreBoard by loading the leaderboard from a
   * JSON file using FileManagerJson.getLeaderboard method.
   * If the leaderboard is null, a new Leaderboard object is created.
   * Calls createLeaderboard method to create the leaderboard UI and populateTable
   * method to populate the table with data.
   *
   * @throws IOException if there is an error reading the JSON file.
   */
  @FXML
  public void initialize() throws IOException {
    leaderboard = FileManagerJson.getLeaderboard("Leaderboard");
    scoreboard = FileManagerJson.getLeaderboard("currentgame");
    if (leaderboard == null) {
      leaderboard = new Leaderboard();
    }
    createLeaderboard();
    populateLeaderboard();
    populateScoreboard();
  }

  /**
   * Adds the current game's scoreboard to the leaderboard, sorts it, and saves it
   * to a file.
   *
   * @throws IOException if there is an error reading or writing the file.
   */
  public void createLeaderboard() throws IOException {
    leaderboard.addScoreboard(scoreboard);
    leaderboard.sortLeaderboard();
    FileManagerJson.saveScoreboard(leaderboard);
  }

  /**
   * Populates the table with the top 10 players in the leaderboard.
   * Clears the name and wins items before adding the new data.
   */
  private void populateLeaderboard() {
    lbName.getItems().clear();
    lbWins.getItems().clear();
    for (Player player : leaderboard.getTopPlayers(10)) {
      lbName.getItems().add(player.getName());
      lbWins.getItems().add(player.getWins());
    }
  }

  private void populateScoreboard() {
    sbName.getItems().clear();
    sbWins.getItems().clear();
    for (Player player : scoreboard.getTopPlayers(10)) {
      sbName.getItems().add(player.getName());
      sbWins.getItems().add(player.getWins());
    }
  }
}