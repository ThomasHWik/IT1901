package PadelApp.springboot.restserver;

import PadelApp.core.Leaderboard;
import PadelApp.core.Scoreboard;
import PadelApp.json.FileManagerJson;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 * This class provides methods to manage the PadelModelService, which is
 * responsible for managing the Leaderboard and Scoreboard data.
 * The class provides methods to save, get and add to the Leaderboard, as well
 * as initialize the Leaderboard.
 * The Leaderboard is saved as a JSON file using the FileManagerJson class.
 */
@Service
public class PadelModelService {
  private String currentFilename = "Leaderboard";

  /**
   * Saves the given leaderboard to a JSON file using the FileManagerJson class.
   *
   * @param leaderboard the leaderboard to be saved
   * @return true if the leaderboard was successfully saved, false otherwise
   */
  public boolean saveLeaderboard(Leaderboard leaderboard) {
    System.out.println("savingLeaderboard Service");
    try {
      FileManagerJson.saveScoreboard(new Scoreboard("Leaderboard", leaderboard.getScorelist()));
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Retrieves a scoreboard from a JSON file.
   *
   * @param filename the name of the JSON file to retrieve the scoreboard from
   * @return the scoreboard retrieved from the JSON file
   */
  public Scoreboard getScoreboard(String filename) {
    return FileManagerJson.getScoreboard(filename);
  }

  /**
   * Returns the leaderboard object by calling the getLeaderboard method of the
   * FileManagerJson class.
   *
   * @return the leaderboard object
   */
  public Leaderboard getLeaderboard() {
    Leaderboard leaderboard = FileManagerJson.getLeaderboard(currentFilename);
    if (leaderboard != null) {
      return leaderboard;
    } else {
      return new Leaderboard();
    }
  }

  /**
   * Adds a scoreboard to the leaderboard.
   * If the leaderboard already exists, the scoreboard is added to it.
   * If the leaderboard does not exist, a new leaderboard is created with the
   * scoreboard.
   *
   * @param scoreboard the scoreboard to add to the leaderboard
   * @return true if the scoreboard was successfully added, false otherwise
   */
  public boolean addToLeaderboard(Scoreboard scoreboard) {
    Leaderboard leaderboard = FileManagerJson.getLeaderboard(currentFilename);
    if (leaderboard == null) {
      leaderboard = new Leaderboard();
    }
    try {
      leaderboard.addScoreboard(scoreboard); // Add the new scoreboard
      saveLeaderboard(leaderboard);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Initializes the PadelModelService by creating a new Leaderboard object and
   * saving it.
   */
  public void initialize() {
    Leaderboard leaderboard = new Leaderboard();
    saveLeaderboard(leaderboard);
  }
}