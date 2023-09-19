package app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppControllerPadel {

    //private ArrayList<Players>

    @FXML
    private TextField addName, addAge;

    @FXML
    private TextArea players;

    @FXML
    private Button AddPlayer;

    private int StringToInt(String string){
        return Integer.valueOf(string);
    }

    @FXML
    void AddPlayer(ActionEvent event){

        Player player= new Player(addName.getText(), StringToInt(addAge.getText()),2);
        
    }


}
