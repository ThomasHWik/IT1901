package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import FileManaging.Getplayerlistoffile;
import Logic.CreatePlayerPairs;
import Logic.Player;
import Logic.PlayerPair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AppControllerGames {

    private Getplayerlistoffile reader = new Getplayerlistoffile();
    private List<Player> Player = new ArrayList<>();
    private CreatePlayerPairs pairs = new CreatePlayerPairs(Player);
    private List<PlayerPair> Pairs = new ArrayList<>();

    @FXML
    private TextArea text;

    @FXML
    private Button GoToScore, test, NewRound;

    @FXML
    private ListView<String> Player1, Player2;

    @FXML
    void NewRound(ActionEvent event) throws FileNotFoundException, IOException{
        setPairs();

        ArrayList<String> players1 = new ArrayList<>();
        ArrayList<String> players2 = new ArrayList<>();

        for (int i = 0; i< Pairs.size(); i++) {
            String player1 = Pairs.get(i).getPlayer1().getName();
            players1.add(player1);
            String player2 = Pairs.get(i).getPlayer2().getName();
            players2.add(player2);

        }
        ObservableList<String> nr1 = FXCollections.observableArrayList(players1);
        ObservableList<String> nr2 = FXCollections.observableArrayList(players2);

        Player1.setItems(nr1);
        Player2.setItems(nr2);


    }

    private void setPairs() throws FileNotFoundException, IOException{
        List<Player> list=new ArrayList<>();
        list = reader.getListOfPlayers("Players.txt");
        pairs = new CreatePlayerPairs(list);

        for (int i = 0; i < pairs.getPlayerPairs().size(); i++) {
            Pairs.add(pairs.getPlayerPairs().get(i));
        }
    }

    /* @FXML
    void test(ActionEvent event) throws FileNotFoundException, IOException {
        setPairs();

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
    } */

    

    @FXML
    void GoToScore(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scoreBoard.fxml"));
            Stage stage = (Stage) GoToScore.getScene().getWindow();
            stage.setScene(new Scene(root));
    }
}