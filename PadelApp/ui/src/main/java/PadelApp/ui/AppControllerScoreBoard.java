package PadelApp.ui;

import PadelApp.core.Leaderboard;
import PadelApp.core.Player;
import PadelApp.core.RemoteLeaderboardAccess;
import PadelApp.core.Scoreboard;
import PadelApp.json.FileManagerJson;
import java.io.IOException;
import java.net.URI;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * This class represents the controller for the scoreboard view of the PadelApp.
 * It initializes the leaderboard and populates the table with the top 10
 * players.
 * It also provides methods to create a leaderboard and set the scoreboard for a
 * list of players.
 * The class uses FileManagerJson to read and write data to JSON files.
 */
@SuppressWarnings({"MultipleVariableDeclarations"})
public class AppControllerScoreBoard {

  private Leaderboard leaderboard;
  private Scoreboard scoreboard;
  private RemoteLeaderboardAccess restApi;

  @FXML
  private ListView<String> lbName, sbName;

  @FXML
  private ListView<Integer> lbWins, sbWins;

  /**
   * Initializes the AppControllerScoreBoard by loading the leaderboard from the
   * REST API
   * If the leaderboard is null, a new Leaderboard object is created.
   * Calls createLeaderboard method to create the leaderboard UI and populateTable
   * method to populate the table with data.
   *
   * @throws IOException if there is an error reading the JSON file.
   */
  @FXML
  public void initialize() throws IOException {
    try {
      this.restApi = new RemoteLeaderboardAccess(new URI("http://localhost:8080/api/padel"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    this.scoreboard = FileManagerJson.getScoreboard("currentgame");
    createLeaderboard();
    System.out.println(this.leaderboard.getScorelist());
    populateLeaderboard();
    populateScoreboard();
  }

  /**
   * Adds the current game's scoreboard to the leaderboard
   * and retrieves the updated leaderboard from REST API.
   */
  public void createLeaderboard() {
    this.restApi.sendScoreboard(scoreboard);
    this.leaderboard = this.restApi.getLeaderboard();
  }

  /**
   * Populates the leaderboard with the top 10 players in the leaderboard.
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

  /**
   * Populates the scoreboard with the top 10 players from most recent game.
   * Clears the name and wins items before adding the new data.
   */
  private void populateScoreboard() {
    sbName.getItems().clear();
    sbWins.getItems().clear();
    for (Player player : scoreboard.getTopPlayers(10)) {
      sbName.getItems().add(player.getName());
      sbWins.getItems().add(player.getWins());
    }
  }
}