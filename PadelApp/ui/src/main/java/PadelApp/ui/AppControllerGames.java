package PadelApp.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import PadelApp.json.FileManagerJson;
import PadelApp.core.CreatePlayerPairs;
import PadelApp.core.Player;
import PadelApp.core.PlayerPair;
import PadelApp.core.RoundSelector;
import PadelApp.core.Scoreboard;
import PadelApp.core.gameSetup;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class AppControllerGames {

    private List<Player> Player = new ArrayList<>();
    private CreatePlayerPairs pairs = new CreatePlayerPairs(Player);
    private List<PlayerPair> Pairs = new ArrayList<>();
    private RoundSelector roundSelector = new RoundSelector(0);
    private int chosenRounds = roundSelector.getNumberOfRounds();
    private int round = 0;
    


    private gameSetup courts= new gameSetup(0,Pairs);
    @FXML
    private TextArea error;

    @FXML
    private TextField rounds;

    @FXML
    private Button GoToScore,NewRound;

    @FXML
    private ToggleButton oneOne,oneTwo,twoOne,twoTwo,threeOne1,threeOne2,threeTwo1,threeTwo2,fourOne,fourTwo,fiveOne1,fiveOne2,fiveTwo1,fiveTwo2,sixOne,sixTwo,sevenOne,sevenTwo;

    @FXML
    private Label Court1,Court2,Court3,Court4,Court5,Court6,Court7; 

    private ArrayList<ToggleButton> toggleButtons= new ArrayList<ToggleButton>();

    private void addToggleBs(){
        if (courts.getDouble()==0){
            toggleButtons.add(oneOne);
            toggleButtons.add(oneTwo);
            toggleButtons.add(twoOne);
            toggleButtons.add(twoTwo);
            toggleButtons.add(sixOne);
            toggleButtons.add(sixTwo);
            toggleButtons.add(sevenOne);
            toggleButtons.add(sevenTwo);
            toggleButtons.add(fourOne);
            toggleButtons.add(fourTwo);  
        }
        if (courts.getDouble()==1){
            toggleButtons.add(threeOne1);
            toggleButtons.add(threeTwo1);
            toggleButtons.add(threeOne2);
            toggleButtons.add(threeTwo2);
            toggleButtons.add(oneOne);
            toggleButtons.add(oneTwo);
            toggleButtons.add(twoOne);
            toggleButtons.add(twoTwo);
            toggleButtons.add(fourOne);
            toggleButtons.add(fourTwo); 
        }
        if(courts.getDouble()==2){
            toggleButtons.add(fiveOne1);
            toggleButtons.add(fiveTwo1);
            toggleButtons.add(fiveOne2);
            toggleButtons.add(fiveTwo2);
            toggleButtons.add(threeOne1);
            toggleButtons.add(threeTwo1);
            toggleButtons.add(threeOne2);
            toggleButtons.add(threeTwo2);
            toggleButtons.add(fourOne);
            toggleButtons.add(fourTwo); 
            
        }

    }

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
            shuffel();
            addPlayersToCourts();
            int togglesize = Pairs.size()*2;
            for (int i = 0; i < togglesize; i++){
                toggleButtons.get(i).selectedProperty().set(false);
            }

            updateRound();
        
        }
        
    }

    private void shuffel(){
        if(courts.getDouble()==1 && courts.getSingle()==0) return;
        if(courts.getSingle()==1 && courts.getDouble()==0) return;
        pairs.remakePlayersOrder();
        setPairs();
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

    public int roundSelector(int chosenRounds) throws IOException{
       
        roundSelector.setNumberOfRounds(chosenRounds);
        this.chosenRounds = chosenRounds;    
        updateRound();
         
        return chosenRounds;

    }

   

    private void updateRound() {
        round++;
        rounds.setText(round + " /"+chosenRounds);
        if (round==chosenRounds){
            NewRound.disableProperty().set(true);
            NewRound.visibleProperty().set(false);
        }
    }

    public void CreateGame() throws FileNotFoundException, IOException{
        setPairs();
        createCourts();
        addPlayersToCourts();
    } 

    private void createCourts(){
        if (Pairs.size()>=2){
            courts = new gameSetup(1, Pairs);
        }
        else{
            courts= new gameSetup(0, Pairs);
        }
        addToggleBs();
        //To turn on the right amount of togglebuttons
        int togglesize = Pairs.size()*2;
        for (int i = 0; i < togglesize; i++) {
            toggleButtons.get(i).setDisable(false);
            toggleButtons.get(i).setVisible(true);
        }
        //to turn on the right labels
        if (oneOne.isVisible()){Court1.visibleProperty().set(true);}
        if (twoTwo.isVisible()){Court2.visibleProperty().set(true);}
        if (threeOne1.isVisible()){Court3.visibleProperty().set(true);}
        if (fourOne.isVisible()){Court4.visibleProperty().set(true);}
        if (fiveOne1.isVisible()){Court5.visibleProperty().set(true);} 
        if (sixOne.isVisible()){Court6.visibleProperty().set(true);} 
        if (sevenOne.isVisible()){Court7.visibleProperty().set(true);} 
    }

    private void addPlayersToCourts(){
        int togglesize = Pairs.size()*2;
        for (int i = 0; i < togglesize; i+=2) {
            toggleButtons.get(i).setText(Pairs.get(i/2).getPlayer1().getName() +" : "+ Pairs.get(i/2).getPlayer1().getWins());
            toggleButtons.get(i+1).setText(Pairs.get(i/2).getPlayer2().getName()+" : "+ Pairs.get(i/2).getPlayer2().getWins());   
        }
    }

    public void setPlayerList(ArrayList<Player> playerlist){
        pairs = new CreatePlayerPairs(playerlist);

    }

    private void setPairs() {
            Pairs = pairs.getPlayerPairs();
    }

    @FXML
    void GoToScore(ActionEvent event) throws IOException {
        addPointsToPlayer();
        Player = pairs.getPlayerlist();
        
        FileManagerJson.saveScoreboard(new Scoreboard("currentgame",(ArrayList<Player>)Player));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreBoard.fxml"));
        Parent root = loader.load();
            Stage stage = (Stage) GoToScore.getScene().getWindow();
            stage.setScene(new Scene(root));
            AppControllerScoreBoard score = (AppControllerScoreBoard)loader.getController();
            score.setScoreboard(new ArrayList<>(Player));
    }

    @Override
    public String toString() {
        return "AppControllerGames [Pairs=" + Pairs + ", Player=" + Player + ", pairs=" + pairs + "]";
    }

    
}