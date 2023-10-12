package ui;

import ui.AppControllerPadel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class AppControllerPadelTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Padel.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testAddPlayer() {
        // Input test data
        String playerName = "John";
        String playerAge = "25";
        String Playernumber = "95643241";

        // Locate the text fields and button by their fx:id
        clickOn("#addTlfNr").write(Playernumber);
        clickOn("#addName").write(playerName);
        clickOn("#addAge").write(playerAge);
        clickOn("#AddPlayer");

        // Assert that the text fields are cleared after adding a player
        FxAssert.verifyThat("#addTlfNr", hasText(""));
        FxAssert.verifyThat("#addName", hasText(""));
        FxAssert.verifyThat("#addAge", hasText(""));

        FxAssert.verifyThat("#players", hasText("John, 25"));
      
    }

    @Test
    public void testCreateGame() {
        // Your test logic for the CreateGame method goes here
    }
}
