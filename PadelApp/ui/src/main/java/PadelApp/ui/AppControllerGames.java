package PadelApp.ui;

import PadelApp.core.CreatePlayerPairs;
import PadelApp.core.GameSetup;
import PadelApp.core.Player;
import PadelApp.core.PlayerPair;
import PadelApp.core.RoundSelector;
import PadelApp.core.Scoreboard;
import PadelApp.json.FileManagerJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 * This class represents the controller for the games section of the PadelApp
 * UI. It contains methods for setting up and managing games, including creating
 * player pairs, selecting rounds, shuffling player order, and updating game
 * rounds. It also includes methods for adding players to courts and updating
 * toggle buttons to reflect game selections.
 * The class includes private fields for storing player and player pair lists, a
 * round selector, a game setup, and toggle buttons for each court. It also
 * includes FXML fields for error messages, round selection, and buttons for
 * navigating to the score section and starting a new round.
 * The class includes methods for initializing games, creating courts, adding
 * points to players, and checking if all games have been selected. It also
 * includes methods for updating the round count and selecting player pairs for
 * each court.
 */
@SuppressWarnings({ "MultipleVariableDeclarations", "MemberName"})
public class AppControllerGames {

  private List<Player> playerList = new ArrayList<>();
  private CreatePlayerPairs pairs = new CreatePlayerPairs(playerList);
  private List<PlayerPair> pairsList = new ArrayList<>();
  private RoundSelector roundSelector = new RoundSelector(0);
  private int chosenRounds = roundSelector.getNumberOfRounds();
  private int round = 0;

  private GameSetup courts = new GameSetup(0, pairsList);

  @FXML
  private TextArea error;

  @FXML
  private TextField rounds;

  @FXML
  private Button goToScore, newRound;

  @FXML
  private ToggleButton oneOne, oneTwo, twoOne, twoTwo,
      threeOne1, threeOne2, threeTwo1, threeTwo2,
      fourOne, fourTwo, fiveOne1, fiveOne2, fiveTwo1, fiveTwo2,
      sixOne, sixTwo, sevenOne, sevenTwo;

  @FXML
  private Label Court1, Court2, Court3, Court4, Court5, Court6, Court7;

  private ArrayList<ToggleButton> toggleButtons = new ArrayList<ToggleButton>();

  /**
   * Adds toggle buttons to the toggleButtons list based on the number of courts
   * available.
   * If there are no courts available, adds buttons for all available court
   * options.
   * If there is one court available, adds buttons for that court and the
   * remaining available court options.
   * If there are two courts available, adds buttons for those courts and the
   * remaining available court options.
   */
  private void addToggleBs() {
    // sets up the toggelbuttons so that the players will be plased in the right
    // buttons
    if (courts.getDouble() == 0) {
      toggleButtons.add(oneOne);
      toggleButtons.add(oneTwo);
      toggleButtons.add(twoOne);
      toggleButtons.add(twoTwo);
      toggleButtons.add(sixOne);
      toggleButtons.add(sixTwo);
      toggleButtons.add(sevenOne);
      toggleButtons.add(sevenTwo);
      toggleButtons.add(fourOne);
      toggleButtons.add(fourTwo);
    }
    if (courts.getDouble() == 1) {
      toggleButtons.add(threeOne1);
      toggleButtons.add(threeTwo1);
      toggleButtons.add(threeOne2);
      toggleButtons.add(threeTwo2);
      toggleButtons.add(oneOne);
      toggleButtons.add(oneTwo);
      toggleButtons.add(twoOne);
      toggleButtons.add(twoTwo);
      toggleButtons.add(fourOne);
      toggleButtons.add(fourTwo);
    }
    if (courts.getDouble() == 2) {
      toggleButtons.add(fiveOne1);
      toggleButtons.add(fiveTwo1);
      toggleButtons.add(fiveOne2);
      toggleButtons.add(fiveTwo2);
      toggleButtons.add(threeOne1);
      toggleButtons.add(threeTwo1);
      toggleButtons.add(threeOne2);
      toggleButtons.add(threeTwo2);
      toggleButtons.add(fourOne);
      toggleButtons.add(fourTwo);
    }
  }

  /**
   * This method adds points to the players based on the toggle buttons selected.
   */
  private void addPointsToPlayer() {
    int togglesize = pairsList.size() * 2;
    for (int i = 0; i < togglesize - 1; i += 2) {
      if (toggleButtons.get(i).isSelected() || toggleButtons.get(i + 1).isSelected()) {
        if (toggleButtons.get(i).isSelected()) {
          pairsList.get(i / 2).getPlayer1().addwins();
        } else {
          pairsList.get(i / 2).getPlayer2().addwins();
        }
      }
    }
  }

  /**
   * This method is called when the "New Round" button is clicked. It checks if
   * all games have been selected, and if not, it displays an error message. If
   * all games have been selected, it adds points to the players, shuffles the
   * pairs, adds players to the courts, deselects all toggle buttons, and updates
   * the round.
   *
   * @param event The event that triggered the method.
   * @throws FileNotFoundException If the file is not found.
   * @throws IOException           If an I/O error occurs.
   */
  @FXML
  void newRound(ActionEvent event) throws FileNotFoundException, IOException {
    // sets up new round and adds points to players taht was selected
    if (!allselected()) {
      error.visibleProperty().set(true);
      error.setText("Not all games have been selected");
    } else {
      error.visibleProperty().set(false);
      addPointsToPlayer();
      shuffel();
      addPlayersToCourts();
      int togglesize = pairsList.size() * 2;
      for (int i = 0; i < togglesize; i++) {
        toggleButtons.get(i).selectedProperty().set(false);
      }

      updateRound();
    }
  }

  /**
   * Shuffles the pairs of players and sets them for the game.
   * If there is only one type of court available (single or double), the method
   * returns without shuffling.
   */
  private void shuffel() {
    // suffels the players so that they play against different players each round
    if (courts.getDouble() == 1 && courts.getSingle() == 0) {
      return;
    }
    if (courts.getSingle() == 1 && courts.getDouble() == 0) {
      return;
    }

    pairs.remakePlayersOrder();
    setPairs();
  }

  /**
   * Sets the selected property of threeOne1 and threeOne2 to true when one of
   * them is clicked.
   *
   * @param event the action event that occurred (clicking the pairOne button)
   */
  @FXML
  void court3pairOne(ActionEvent event) {
    // selects both buttons if one is selected
    threeOne1.selectedProperty().set(true);
    threeOne2.selectedProperty().set(true);
  }

  /**
   * Sets the selected property of threeTwo1 and threeTwo2 to true when one of
   * them is clicked.
   *
   * @param event The event that triggered this method.
   */
  @FXML
  void court3pairTwo(ActionEvent event) {
    // selects both buttons if one is selected
    threeTwo1.selectedProperty().set(true);
    threeTwo2.selectedProperty().set(true);
  }

  /**
   * Sets the selected property of fiveOne1 and fiveOne2 to true when one of them
   * is clicked.
   *
   * @param event the action event that occurred (clicking the pairOne button)
   */
  @FXML
  void court5PairOne(ActionEvent event) {
    // selects both buttons if one is selected
    fiveOne1.selectedProperty().set(true);
    fiveOne2.selectedProperty().set(true);
  }

  /**
   * Sets the selected property of fiveTwo1 and tfiveTwo2 to true when one of them
   * is clicked.
   *
   * @param event the action event that occurred (clicking the pairOne button)
   */
  @FXML
  void court5PairTwo(ActionEvent event) {
    // selects both buttons if one is selected
    fiveTwo1.selectedProperty().set(true);
    fiveTwo2.selectedProperty().set(true);
  }

  /**
   * Checks if all toggle buttons are selected.
   *
   * @return true if all toggle buttons are selected, false otherwise.
   */
  private boolean allselected() {
    // checks if there has been selected a winner on each court
    int togglesize = pairsList.size() * 2;
    for (int i = 0; i < togglesize - 1; i += 2) {
      if (!(toggleButtons.get(i).isSelected() || toggleButtons.get(i++).isSelected())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sets the number of rounds for a game and updates the round display.
   *
   * @param chosenRounds the number of rounds chosen for the game
   * @return the number of rounds chosen for the game
   * @throws IOException if an I/O error occurs
   */
  public int roundSelector(int chosenRounds) throws IOException {
    roundSelector.setNumberOfRounds(chosenRounds);
    this.chosenRounds = chosenRounds;
    updateRound();

    return chosenRounds;
  }

  /**
   * Increases the round count by one and updates the text of the rounds label.
   * If the round count equals the chosen rounds, the NewRound button is disabled
   * and hidden.
   */
  private void updateRound() {
    round++;
    rounds.setText(round + " /" + chosenRounds);
    if (round == chosenRounds) {
      newRound.disableProperty().set(true);
      newRound.visibleProperty().set(false);
    }
  }

  /**
   * Initializes the game by creating player pairs, creating courts, and adding
   * players to courts.
   */
  public void createGame(int value) throws FileNotFoundException, IOException {
    setPairs();
    setCourts(value);
    createCourts();
    addPlayersToCourts();
  }

  /**
   * Adds toggle buttons and sets the visibility of the courts based on the number
   * of pairs.
   */
  private void createCourts() {
    addToggleBs();
    // To turn on the right amount of togglebuttons
    int togglesize = pairsList.size() * 2;
    for (int i = 0; i < togglesize; i++) {
      toggleButtons.get(i).setDisable(false);
      toggleButtons.get(i).setVisible(true);
    }
    // to turn on the right labels
    if (oneOne.isVisible()) {
      Court1.visibleProperty().set(true);
    }
    if (twoTwo.isVisible()) {
      Court2.visibleProperty().set(true);
    }
    if (threeOne1.isVisible()) {
      Court3.visibleProperty().set(true);
    }
    if (fourOne.isVisible()) {
      Court4.visibleProperty().set(true);
    }
    if (fiveOne1.isVisible()) {
      Court5.visibleProperty().set(true);
    }
    if (sixOne.isVisible()) {
      Court6.visibleProperty().set(true);
    }
    if (sevenOne.isVisible()) {
      Court7.visibleProperty().set(true);
    }
  }

  private void setCourts(int value) {
    courts = new GameSetup(value, pairsList);
  }

  /**
   * Adds players to courts by setting the text of toggle buttons with player
   * names and their wins.
   * Uses the Pairs list to get player information.
   */
  private void addPlayersToCourts() {
    int togglesize = pairsList.size() * 2;
    for (int i = 0; i < togglesize; i += 2) {
      String name1 = pairsList.get(i / 2).getPlayer1().getName();
      int wins1 = pairsList.get(i / 2).getPlayer1().getWins();
      toggleButtons.get(i).setText(name1 + " : " + wins1);

      String name2 = pairsList.get(i / 2).getPlayer2().getName();
      int wins2 = pairsList.get(i / 2).getPlayer2().getWins();
      toggleButtons.get(i + 1).setText(name2 + " : " + wins2);
    }
  }

  /**
   * Sets the player list and creates pairs of players for the game.
   *
   * @param playerlist the list of players to be set
   */
  public void setPlayerList(ArrayList<Player> playerlist) {
    pairs = new CreatePlayerPairs(playerlist);
  }

  /**
   * Sets the Pairs variable to the player pairs obtained from the pairs object.
   * The Pairs variable is a private field of the AppControllerGames class.
   * The pairs object is obtained from the pairs field of the same class.
   */
  private void setPairs() {
    pairsList = pairs.getPlayerPairs();
  }

  /**
   * This method is called when the "GoToScore" button is clicked. It adds points
   * to the player, saves the scoreboard to a JSON file, and loads the
   * "scoreBoard.fxml" file. It sets the scene to the loaded file and sets the
   * score for the scoreboard.
   *
   * @param event The event that triggered this method.
   * @throws IOException If an I/O error occurs while loading the
   *                     "scoreBoard.fxml" file.
   */
  @FXML
  void goToScore(ActionEvent event) throws IOException {
    addPointsToPlayer();
    playerList = pairs.getPlayerlist();

    FileManagerJson.saveScoreboard(new Scoreboard("currentgame", (ArrayList<Player>) playerList));

    FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreBoard.fxml"));
    Parent root = loader.load();
    Stage stage = (Stage) goToScore.getScene().getWindow();
    stage.setScene(new Scene(root));
  }

  /**
   * Returns a string representation of the AppControllerGames object.
   *
   * @return a string representation of the AppControllerGames object, including
   *         the Pairs, Player, and pairs fields.
   */
  @Override
  public String toString() {
    String info = "[Pairs=" + pairsList + ", Player=" + playerList + ", pairs=" + pairs + "]";
    return "AppControllerGames " + info;
  }
}