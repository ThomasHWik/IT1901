package PadelApp.ui;

import java.io.IOException;
import java.util.ArrayList;

import PadelApp.core.Player;
import PadelApp.core.RoundSelector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AppControllerPadel {

    private ArrayList<Player> playerlist = new ArrayList<>();

    @FXML
    private TextField addName, addAge, addTlfNr, InputRounds;

    @FXML
    private TextArea players;

    @FXML
    private Button AddPlayer, CreateGame;

    @FXML 
    private Label errorMsg, errorCreateGamesMsg;


    @FXML
    void AddPlayer(ActionEvent event) throws IOException {
        //try catch to check if the input is valid
        try {
            Player player= new Player(addName.getText(), StringToInt(addAge.getText()), StringToInt(addTlfNr.getText()));
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

        for (int i = 0; i< playerlist.size(); i++) {
            String Name = playerlist.get(i).getName();
            String age = IntToString(playerlist.get(i).getAge());
            list.add(Name + ", " + age);
        }

        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append("\n");
        }

        String output = sb.toString();
        players.setText(output);

        updateGUI();
    }

    
    @FXML
    void CreateGame(ActionEvent event) throws IOException {




        
        refreshErrorCreateGamesMsg();
        if (playerlist.size() % 2 != 0){
            errorCreateGames("Must be even number of players");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("games.fxml"));
        Parent root = loader.load();
            Stage stage = (Stage) CreateGame.getScene().getWindow();
            stage.setScene(new Scene(root));
            AppControllerGames games = (AppControllerGames)loader.getController();
            games.setPlayerList(playerlist);
            games.CreateGame();
            games.roundSelector(chosenRounds);
            
    }
   

    //handles invalid input and shows the error msg for the user
    @FXML
    private void error(String message) {
        errorMsg.setText(message);
    }

    //clears error msg
    @FXML
    private void refreshErrorMsg() {
        errorMsg.setText("");
    }

    @FXML
    private void errorCreateGames(String message){
        errorCreateGamesMsg.setText(message);
    }

    @FXML
    private void refreshErrorCreateGamesMsg(){
        errorCreateGamesMsg.setText("");
    }

    private void updateGUI() {
        addName.clear();
        addAge.clear();
        addTlfNr.clear();
    }

    private int StringToInt(String string) {
        return Integer.valueOf(string);
    }

    private String IntToString(int number) {
        return Integer.toString(number);
    }
}