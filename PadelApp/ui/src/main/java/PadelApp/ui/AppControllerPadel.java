package PadelApp.ui;

import PadelApp.core.Player;
import PadelApp.core.RoundSelector;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This class represents the controller for the PadelApp UI. It handles adding
 * players to the player list,
 * creating games, and updating the GUI. It also contains methods for error
 * handling and refreshing error messages.
 * The class has FXML fields for the text fields, text area, buttons, and labels
 * used in the UI.
 * The class has private fields for the player list and methods for converting
 * between String and int.
 * The class also has methods for updating the GUI and creating games.
 */
public class AppControllerPadel {

  private ArrayList<Player> playerlist = new ArrayList<>();

  @FXML
  private TextField addName, addAge, addTlfNr, inputRounds;

  @FXML
  private TextArea players;

  @FXML
  private Button addPlayer, createGame;

  @FXML
  private Label errorMsg, errorCreateGamesMsg;

  @FXML
  private Slider courtCount;


  /**
   * Adds a new player to the player list and updates the GUI accordingly.
   *
   * @param event The event that triggered the method call.
   * @throws IOException If an I/O error occurs.
   */
  @FXML
  void addPlayer(ActionEvent event) throws IOException {
    // try catch to check if the input is valid
    try {
      String name = addName.getText();
      int age = stringToInt(addAge.getText());
      int tlfNr = stringToInt(addTlfNr.getText());
      Player player = new Player(name, age, tlfNr);
      playerlist.add(player);
      refreshErrorMsg();
    } catch (Exception e) {
      if (e instanceof IllegalArgumentException) {
        error(e.getMessage());
      } else {
        error("Invalid input!");
      }
      return;
    }

    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < playerlist.size(); i++) {
      String name = playerlist.get(i).getName();
      String age = intToString(playerlist.get(i).getAge());
      list.add(name + ", " + age);
    }

    StringBuilder sb = new StringBuilder();
    for (String item : list) {
      sb.append(item).append("\n");
    }

    String output = sb.toString();
    players.setText(output);

    updateGui();
  }

  /**
   * This method is called when the "Create Game" button is clicked. It retrieves
   * the number of rounds from the "InputRounds" text field, checks if the number
   * of players is even, and displays an error message if it is not. It then loads
   * the "games.fxml" file, sets the player list, creates a game, and selects the
   * number of rounds.
   *
   * @param event The event that triggered the method call.
   * @throws IOException If an I/O error occurs while loading the "games.fxml"
   *                     file.
   */
  @FXML
  void createGame(ActionEvent event) throws IOException {
    refreshErrorCreateGamesMsg();
    if (playerlist.size() % 2 != 0) {
      errorCreateGames("Must be even number of players");
      return;
    }
    FXMLLoader loader = new FXMLLoader(getClass().getResource("games.fxml"));
    Parent root = loader.load();
    Stage stage = (Stage) createGame.getScene().getWindow();
    stage.setScene(new Scene(root));
    AppControllerGames games = (AppControllerGames) loader.getController();
    int chosenRounds = Integer.parseInt(inputRounds.getText());
    games.setPlayerList(playerlist);
    games.createGame(setcourts());
    games.roundSelector(chosenRounds);
  }

  /**
     * @return the integer value of the courtCount.
     */
    private int setcourts() {
      int value = (int) courtCount.getValue();
      if (playerlist.size() < 8 && value == 2) {return 1;}
      if (playerlist.size() < 4 && value > 0) {return 0;}

      return value;
  }

  /**
   * Sets the error message to be displayed in the UI.
   *
   * @param message the error message to be displayed
   */
  @FXML
  private void error(String message) {
    errorMsg.setText(message);
  }

  /**
   * Clears the error message displayed on the UI.
   */
  @FXML
  private void refreshErrorMsg() {
    errorMsg.setText("");
  }

  /**
   * Sets the error message for creating games.
   *
   * @param message the error message to be displayed
   */
  @FXML
  private void errorCreateGames(String message) {
    errorCreateGamesMsg.setText(message);
  }

  /**
   * This method refreshes the error message displayed on the UI for creating
   * games.
   * It sets the text of the errorCreateGamesMsg label to an empty string.
   */
  @FXML
  private void refreshErrorCreateGamesMsg() {
    errorCreateGamesMsg.setText("");
  }

  /**
   * Clears the text fields for name, age, and phone number in the GUI.
   */
  private void updateGui() {
    addName.clear();
    addAge.clear();
    addTlfNr.clear();
  }

  /**
   * Converts a string to an integer.
   *
   * @param string the string to be converted to an integer
   * @return the integer value of the string
   */
  private int stringToInt(String string) {
    return Integer.parseInt(string);
  }

  /**
   * Converts an integer to a string representation.
   *
   * @param number the integer to be converted
   * @return the string representation of the integer
   */
  private String intToString(int number) {
    return Integer.toString(number);
  }
}