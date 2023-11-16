package PadelApp.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;



import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class AppControllerPadelTest extends ApplicationTest {

    private final FXMLLoader loader = new FXMLLoader(getClass().getResource("padel.fxml"));

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = this.loader;
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void Add2Players() {
        // Input test data
        String player1Name = "John";
        String player1Age = "25";
        String Player1number = "95643241";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Player1number);
        clickOn("#addName").write(player1Name);
        clickOn("#addAge").write(player1Age);
        clickOn("#addPlayer");

        String player2Name = "Tom";
        String player2Age = "21";
        String Player2number = "45464748";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Player2number);
        clickOn("#addName").write(player2Name);
        clickOn("#addAge").write(player2Age);
        clickOn("#addPlayer");

    }

    @Test
    public void testAddPlayer() {
        // Input test data
        String playerName = "John";
        String playerAge = "25";
        String playernumber = "95643241";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(playernumber);
        clickOn("#addName").write(playerName);
        clickOn("#addAge").write(playerAge);
        clickOn("#addPlayer");

        // Assert that the text fields are cleared after adding a player
        //FxAssert.verifyThat("#addTlfNr", hasText(""));
        FxAssert.verifyThat("#addName", hasText(""));
        FxAssert.verifyThat("#addAge", hasText(""));
    }

    @Test
    public void testTextAreaPlayer(){
        Add2Players();

        FxAssert.verifyThat("#players", hasText("John, 25\nTom, 21\n"));
    }

    @Test
    public void testCreateGame() {
        Add2Players();
        clickOn("#inputRounds").write("0");
        clickOn("#createGame");

        // Verify that the errorCreateGamesMsg Label is visible
        FxAssert.verifyThat("#errorCreateGamesMsg", LabeledMatchers.hasText("Must choose number of rounds between 1-10"));
    }

    @Test
    public void TestEvenNumberPlayers(){
        String playerName = "John";
        String playerAge = "25";
        String Playernumber = "95643241";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Playernumber);
        clickOn("#addName").write(playerName);
        clickOn("#addAge").write(playerAge);
        clickOn("#addPlayer");
        clickOn("#inputRounds").write("5");
        clickOn("#createGame");

        FxAssert.verifyThat("#errorCreateGamesMsg", LabeledMatchers.hasText("Must be even number of players"));

    }

    @Test
    public void testmax10() {
        Add2Players();
        Add2Players();
        Add2Players();
        Add2Players();
        Add2Players();

        String playerName = "Stine";
        String playerAge = "22";
        String Playernumber = "95643256";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Playernumber);
        clickOn("#addName").write(playerName);
        clickOn("#addAge").write(playerAge);
        clickOn("#addPlayer");

        // Verify that the errorsMsg is visible
        FxAssert.verifyThat("#errorMsg", LabeledMatchers.hasText("There can not be more then 10 players"));
    }

    @Test
    public void testPlayerCount() {
        Add2Players();

        FxAssert.verifyThat("#numberOfPlayers", LabeledMatchers.hasText("2"));
    }
}