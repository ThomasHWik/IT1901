package ui;

import ui.AppControllerPadel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;



/**
 * TestFX App test
 */
public class AppTest extends ApplicationTest {

    private AppControllerPadel controller;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("padel.fxml"));
        root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    } 


    private ListView<String> findListViewById(String id) {
        return lookup(id).queryListView();
    }

    @Test
    public void testAddPlayer() {
        // Simulate user interactions here (e.g., click buttons, enter text)

        clickOn("#addName").write("John");
        clickOn("#addAge").write("30");
        clickOn("#AddPlayer");

        // Add assertions to verify the behavior of your controller
        ListView<String> listView = findListViewById("#players");
        String expectedItem = "John, 30";
        Assertions.assertTrue(listView.getItems().contains(expectedItem));
    
    }


}
