package app;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
    private Button GoToScore,NewRound;

    @FXML
    private ListView<String> Player1, Player2;

    @FXML
    private RadioButton onel,oner,twol,twor,threel,threer,fourl,fourr,fivel,fiver,sixl,sixr,sevenl,sevenr,eightl,eightr,ninel,niner,tenl,tenr,elevenl,elevenr;

    private ArrayList<RadioButton> radioButtons= new ArrayList<RadioButton>();

    private void addRadioBs(){
        radioButtons.add(onel);
        radioButtons.add(oner);
        radioButtons.add(twol);
        radioButtons.add(twor);
        radioButtons.add(threel);
        radioButtons.add(threer);
        radioButtons.add(fourl);
        radioButtons.add(fourr);
        radioButtons.add(fivel);
        radioButtons.add(fiver);
        radioButtons.add(sixl);
        radioButtons.add(sixr);
        radioButtons.add(sevenl);
        radioButtons.add(sevenr);
        radioButtons.add(eightl);
        radioButtons.add(eightr);
        radioButtons.add(ninel);
        radioButtons.add(niner);
        radioButtons.add(tenl);
        radioButtons.add(tenr);
        radioButtons.add(elevenl);
        radioButtons.add(elevenr);
    }
    private void addPlayersToVsLists(){
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

    }

    private void addPointsToPlayer(){
        int radiosize = Pairs.size()*2;
        for (int i = 0; i < radiosize-1; i+=2) {
            if (radioButtons.get(i).isSelected() || radioButtons.get(i+1).isSelected()){
                if(radioButtons.get(i).isSelected()){
                    Pairs.get(i/2).getPlayer1().addwins();
                }
                else{Pairs.get(i/2).getPlayer2().addwins();
                }
            }
            else{
                Pairs.get(i/2).getPlayer1().setWins(0);
                Pairs.get(i/2).getPlayer2().setWins(0);
            }
        }


    }

    @FXML
    void NewRound(ActionEvent event) throws FileNotFoundException, IOException{
        addPointsToPlayer();

        addPlayersToVsLists();

        int radiosize = Pairs.size()*2;
        for (int i = 0; i < radiosize; i++){
            radioButtons.get(i).selectedProperty().set(false);
        }
    }

    public void CreateGame() throws FileNotFoundException, IOException{
        setPairs();
        addRadioBs();
        addPlayersToVsLists();

        //To turn on the right amount of radiobuttons
        int radiosize = Pairs.size()*2;
        for (int i = 0; i < radiosize; i++) {
            radioButtons.get(i).setDisable(false);
            radioButtons.get(i).setVisible(true);
        }
    }

    public void setPlayerList(ArrayList<Player> playerlist){
        pairs = new CreatePlayerPairs(playerlist);

    }

    private void setPairs() throws FileNotFoundException, IOException{
        /* List<Player> list=new ArrayList<>();
        list = reader.getListOfPlayers("Players.txt");
        pairs = new CreatePlayerPairs(list); */

        for (int i = 0; i < pairs.getPlayerPairs().size(); i++) {
            Pairs.add(pairs.getPlayerPairs().get(i));
        }
    }

    @FXML
    void GoToScore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreBoard.fxml"));
        Parent root = loader.load();
            Stage stage = (Stage) GoToScore.getScene().getWindow();
            stage.setScene(new Scene(root));
            AppControllerGames score = (AppControllerGames)loader.getController();
            
    }
}