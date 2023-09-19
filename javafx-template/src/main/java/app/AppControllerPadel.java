package app;


import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppControllerPadel {

    private ArrayList<Player> playerlist = new ArrayList<>();

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
        playerlist.add(player);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i< playerlist.size(); i++) {
            String Name = playerlist.get(i).getName();
            list.add(Name);
        }
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append("\n");
        }
        String output = sb.toString();
        players.setText(output);

        addName.setText("");
        addAge.setText("");
        
    }


}
