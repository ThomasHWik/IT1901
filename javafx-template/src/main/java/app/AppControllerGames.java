package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AppControllerGames {

    private FileManager fileManager;
    private CreatePlayerPairs pairs = new CreatePlayerPairs(fileManager.getListOfPlayers());

    @FXML
    private Button GoToScore, test;

    @FXML
    private TableView GamePairs = new TableView();

    /* @FXML
    void test(ActionEvent event){
        TableColumn Player1 = new TableColumn("Name");
        Player1.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn Player2 = new TableColumn("Name");
        Player2.setCellValueFactory(new PropertyValueFactory<>("Name"));

        GamePairs.getColumns().addAll(Player1, Player2);

        Player player1 = new Player("Linda", 22);
        Player player2 = new Player("Lars", 12);
        GamePairs.getItems().add(player1);

    } */

    

    @FXML
    void GoToScore(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("scoreBoard.fxml"));
            Stage stage = (Stage) GoToScore.getScene().getWindow();
            stage.setScene(new Scene(root));
    }
}