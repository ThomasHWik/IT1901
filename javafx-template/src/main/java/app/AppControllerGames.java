package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AppControllerGames {
    @FXML
    private TextField addName, addAge;

    @FXML
    private Button AddPlayer;

    private int StringToInt(String string){
        return Integer.valueOf(string);
    }

    
    
}
