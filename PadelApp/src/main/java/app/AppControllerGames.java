package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import FileManaging.Getplayerlistoffile;
import Logic.CreatePlayerPairs;
import Logic.Player;
import Logic.PlayerPair;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AppControllerGames {

    private Getplayerlistoffile reader = new Getplayerlistoffile();
    private List<Player> Player = new ArrayList<>();
    private CreatePlayerPairs pairs = new CreatePlayerPairs(Player);
    private List<PlayerPair> Pairs = new ArrayList<>();
    private AppControllerScoreBoard sbController = new AppControllerScoreBoard();

    @FXML
    private TextArea text;

    @FXML
    void test(ActionEvent event) throws FileNotFoundException, IOException {
        List<Player> list=new ArrayList<>();
        list = reader.getListOfPlayers("Players.txt");
        pairs = new CreatePlayerPairs(list);

        for (int i = 0; i < pairs.getPlayerPairs().size(); i++) {
            Pairs.add(pairs.getPlayerPairs().get(i));
        }

        ArrayList<String> exlist = new ArrayList<>();

        for (int i = 0; i< Pairs.size(); i++) {
            String player1 = Pairs.get(i).getPlayer1().getName();
            String player2 = Pairs.get(i).getPlayer2().getName();
            exlist.add(player1 + " vs " + player2);
        }

        StringBuilder sb = new StringBuilder();
        for (String item : exlist) {
            sb.append(item).append("\n");
        }

        String output = sb.toString();
        text.setText(output);
    }

    @FXML
    private Button GoToScore, test;

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
    void GoToScore(ActionEvent event) throws IOException {
        sbController.setScorelist(Player);

        Parent root = FXMLLoader.load(getClass().getResource("scoreBoard.fxml"));
            Stage stage = (Stage) GoToScore.getScene().getWindow();
            stage.setScene(new Scene(root));
    }
}