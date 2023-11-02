package PadelApp.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import PadelApp.json.FileManagerJson;
import PadelApp.core.CreatePlayerPairs;
import PadelApp.core.Player;
import PadelApp.core.PlayerPair;
import PadelApp.core.Scoreboard;
import PadelApp.core.gameSetup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class AppControllerGames {

    private List<Player> Player = new ArrayList<>();
    private CreatePlayerPairs pairs = new CreatePlayerPairs(Player);
    private List<PlayerPair> Pairs = new ArrayList<>();
    private gameSetup courts= new gameSetup(0,Pairs);
    private int round=1;

    @FXML
    private TextArea error;

    @FXML
    private TextField rounds;

    @FXML
    private Button GoToScore,NewRound;

    @FXML
    private ToggleButton oneOne,oneTwo,twoOne,twoTwo,threeOne1,threeOne2,threeTwo1,threeTwo2,fourOne,fourTwo;

    private ArrayList<ToggleButton> toggleButtons= new ArrayList<ToggleButton>();

    private void addToggleBs(){
        toggleButtons.add(oneOne);
        toggleButtons.add(oneTwo);
        toggleButtons.add(twoOne);
        toggleButtons.add(twoTwo);
        toggleButtons.add(threeOne1);
        toggleButtons.add(threeOne2);
        toggleButtons.add(threeTwo1);
        toggleButtons.add(threeTwo2);
        toggleButtons.add(fourOne);
        toggleButtons.add(fourTwo);  
    }


   /*  private void addPlayersToVsLists(){
        //making to seperate list that tells sais the name of the player and how many points they have.
        ArrayList<String> players1 = new ArrayList<>();
        ArrayList<String> players2 = new ArrayList<>();

        for (int i = 0; i< Pairs.size(); i++) {
            String player1 = Pairs.get(i).getPlayer1().getName()+" : "+ Pairs.get(i).getPlayer1().getWins();
            players1.add(player1);
            String player2 = Pairs.get(i).getPlayer2().getName()+" : "+ Pairs.get(i).getPlayer2().getWins();
            players2.add(player2);

        }
        ObservableList<String> nr1 = FXCollections.observableArrayList(players1);
        ObservableList<String> nr2 = FXCollections.observableArrayList(players2);

        Player1.setItems(nr1);
        Player2.setItems(nr2);

    } */

   private void addPointsToPlayer(){
        int togglesize = Pairs.size()*2;
        for (int i = 0; i < togglesize-1; i+=2) {
            if (toggleButtons.get(i).isSelected() || toggleButtons.get(i+1).isSelected()){
                if(toggleButtons.get(i).isSelected()){
                    Pairs.get(i/2).getPlayer1().addwins();
                }
                else{
                    Pairs.get(i/2).getPlayer2().addwins();
                }
            } 
        }
    } 

   @FXML
    void NewRound(ActionEvent event) throws FileNotFoundException, IOException{
        if (!allselected()){
            error.visibleProperty().set(true);
            error.setText("Not all games have been selected");
        }
        else{
            error.visibleProperty().set(false);
            addPointsToPlayer();
            addPlayersToCourts();
            int togglesize = Pairs.size()*2;
            for (int i = 0; i < togglesize; i++){
                toggleButtons.get(i).selectedProperty().set(false);
            }
            updateRound();
        }
        
    }
    @FXML
    void pairOne(ActionEvent event){
        threeOne1.selectedProperty().set(true);
        threeOne2.selectedProperty().set(true);
    }
    @FXML
    void pairTwo(ActionEvent event){
        threeTwo1.selectedProperty().set(true);
        threeTwo2.selectedProperty().set(true);
    }


    private boolean allselected() {
        int togglesize = Pairs.size()*2;
        for (int i = 0; i < togglesize-1; i+=2){
            if (!(toggleButtons.get(i).isSelected() || toggleButtons.get(i+1).isSelected())){
                return false;
            }
        }
        return true;
    } 

    private void updateRound() {
        round++;
        rounds.setText(round + " / 5");
        if (round==5){
            NewRound.disableProperty().set(true);
            NewRound.visibleProperty().set(false);
        }
    }

    public void CreateGame() throws FileNotFoundException, IOException{
        setPairs();
        addToggleBs();

        //To turn on the right amount of togglebuttons
        int togglesize = Pairs.size()*2;
        for (int i = 0; i < togglesize; i++) {
            toggleButtons.get(i).setDisable(false);
            toggleButtons.get(i).setVisible(true);
        }

        addPlayersToCourts();
    } 

    private void createCourts(){
        courts= 
    }

    private void addPlayersToCourts(){
        for (int i = 0; i < toggleButtons.size(); i+=2) {
            toggleButtons.get(i).setText(Pairs.get(i/2).getPlayer1().getName() +" : "+ Pairs.get(i/2).getPlayer1().getWins());
            toggleButtons.get(i+1).setText(Pairs.get(i/2).getPlayer2().getName()+" : "+ Pairs.get(i/2).getPlayer2().getWins());   
        }
    }

    public void setPlayerList(ArrayList<Player> playerlist){
        pairs = new CreatePlayerPairs(playerlist);

    }

    private void setPairs() throws FileNotFoundException, IOException{

        for (int i = 0; i < pairs.getPlayerPairs().size(); i++) {
            Pairs.add(pairs.getPlayerPairs().get(i));
        }
    }

    @FXML
    void GoToScore(ActionEvent event) throws IOException {
        addPointsToPlayer();

        for (int i = 0; i < Pairs.size(); i++) {
            Player.add(Pairs.get(i).getPlayer1());
            Player.add(Pairs.get(i).getPlayer2());
        }

        FileManagerJson.saveScoreboard(new Scoreboard("currentgame",(ArrayList<Player>)Player));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreBoard.fxml"));

        Parent root = loader.load();
            Stage stage = (Stage) GoToScore.getScene().getWindow();
            stage.setScene(new Scene(root));
    }
}