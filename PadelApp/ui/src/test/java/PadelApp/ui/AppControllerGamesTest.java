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
    private Button CreateGame;

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
        Stage stage = (Stage) CreateGame.getScene().getWindow();
        stage.setScene(new Scene(root));
        AppControllerGames games = (AppControllerGames) loader.getController();
        games.setPlayerList(playerList);
        games.CreateGame();
    }

    public void AddPlayers() {
        // Input test data
        String player1Name = "John";
        String player1Age = "25";
        String Player1number = "95643241";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Player1number);
        clickOn("#addName").write(player1Name);
        clickOn("#addAge").write(player1Age);
        clickOn("#AddPlayer");

        String player2Name = "Tom";
        String player2Age = "21";
        String Player2number = "45464748";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Player2number);
        clickOn("#addName").write(player2Name);
        clickOn("#addAge").write(player2Age);
        clickOn("#AddPlayer");

        String player3Name = "Tim";
        String player3Age = "19";
        String Player3number = "99989796";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Player3number);
        clickOn("#addName").write(player3Name);
        clickOn("#addAge").write(player3Age);
        clickOn("#AddPlayer");

        String player4Name = "Ron";
        String player4Age = "25";
        String Player4number = "49484746";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Player4number);
        clickOn("#addName").write(player4Name);
        clickOn("#addAge").write(player4Age);
        clickOn("#AddPlayer");
        clickOn("#CreateGame");

    }

    @Test
    public void testAddPointstoPlayer() {
        AddPlayers();

        clickOn("#onel");
        clickOn("#twor");
        clickOn("#NewRound");

        clickOn("#oner");
        clickOn("#twor");
        clickOn("#NewRound");

        clickOn("#oner");
        clickOn("#twol");
        clickOn("#NewRound");
        clickOn("#GoToScore");

        playerList = FileManagerJson.getScoreboard("currentgame").getScorelist();

        assertTrue(playerList.get(0).getWins() == 1);
        assertTrue(playerList.get(1).getWins() == 2);
        assertTrue(playerList.get(2).getWins() == 1);
        assertTrue(playerList.get(3).getWins() == 2);

    }

}
