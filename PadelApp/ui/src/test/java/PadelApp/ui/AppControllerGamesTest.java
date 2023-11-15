package PadelApp.ui;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import PadelApp.json.FileManagerJson;
import PadelApp.core.Player;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class AppControllerGamesTest extends ApplicationTest {
    public ArrayList<Player> playerList;
    private Button createGame;

    private final FXMLLoader loader = new FXMLLoader(getClass().getResource("padel.fxml"));

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = this.loader;
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    void CreateGame(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("games.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) createGame.getScene().getWindow();
        stage.setScene(new Scene(root));
        AppControllerGames games = (AppControllerGames) loader.getController();
        games.setPlayerList(playerList);
        games.createGame(0);
    }

    public void Add4Players() {
        // Input test data
        String player1Name = "John";
        String player1Age = "25";
        String player1number = "95643241";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(player1number);
        clickOn("#addName").write(player1Name);
        clickOn("#addAge").write(player1Age);
        clickOn("#addPlayer");

        String player2Name = "Tom";
        String player2Age = "21";
        String player2number = "45464748";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(player2number);
        clickOn("#addName").write(player2Name);
        clickOn("#addAge").write(player2Age);
        clickOn("#addPlayer");

        String player3Name = "Tim";
        String player3Age = "19";
        String player3number = "99989796";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(player3number);
        clickOn("#addName").write(player3Name);
        clickOn("#addAge").write(player3Age);
        clickOn("#addPlayer");

        String player4Name = "Ron";
        String player4Age = "25";
        String player4number = "49484746";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(player4number);
        clickOn("#addName").write(player4Name);
        clickOn("#addAge").write(player4Age);
        clickOn("#addPlayer");
        clickOn("#inputRounds").write("5");
        clickOn("#createGame");
    }

    public void Add2Players() {
        // Input test data
        String player1Name = "John";
        String player1Age = "25";
        String player1number = "95643241";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(player1number);
        clickOn("#addName").write(player1Name);
        clickOn("#addAge").write(player1Age);
        clickOn("#addPlayer");

        String player2Name = "Tom";
        String player2Age = "21";
        String player2number = "45464748";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(player2number);
        clickOn("#addName").write(player2Name);
        clickOn("#addAge").write(player2Age);
        clickOn("#addPlayer");
        clickOn("#inputRounds").write("5");
        clickOn("#createGame");
    }

    @Test
    public void testAddPointstoPlayer4() {
        Add4Players();
        clickOn("#threeOne1");
        clickOn("#newRound");

        clickOn("#threeOne2");
        clickOn("#newRound");

        clickOn("#threeTwo1");
        clickOn("#newRound");

        clickOn("#threeTwo2");
        clickOn("#newRound");

        clickOn("#threeTwo2");
        clickOn("#goToScore");

        playerList = FileManagerJson.getScoreboard("currentgame").getScorelist();

        assertTrue(playerList.get(0).getWins() == 2);
        assertTrue(playerList.get(1).getWins() == 3);
        assertTrue(playerList.get(2).getWins() == 2);
        assertTrue(playerList.get(3).getWins() == 3);
    }

    @Test
    public void testAddPointstoPlayer2() {
        Add2Players();
        // threeone1, threeone2
        // threetwo1, threetwo2
        clickOn("#oneOne");
        clickOn("#newRound");

        clickOn("#oneTwo");
        clickOn("#newRound");

        clickOn("#oneTwo");
        clickOn("#newRound");

        clickOn("#oneOne");
        clickOn("#newRound");

        clickOn("#goToScore");

        playerList = FileManagerJson.getScoreboard("currentgame").getScorelist();

        assertTrue(playerList.get(0).getWins() == 2);
        assertTrue(playerList.get(1).getWins() == 2);
    }
}