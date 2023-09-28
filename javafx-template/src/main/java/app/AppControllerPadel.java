package app;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppControllerPadel {

    private FileManager fm = new FileManager();
    private ArrayList<Player> playerlist = new ArrayList<>();

    @FXML
    private TextField addName, addAge;

    @FXML
    private TextArea players;

    @FXML
    private Button AddPlayer, CreateGame;

    @FXML
    void AddPlayer(ActionEvent event) throws IOException {

        Player player= new Player(addName.getText(), StringToInt(addAge.getText()));
        playerlist.add(player);

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

    private void updateGUI() {
        addName.clear();
        addAge.clear();
    }

    private int StringToInt(String string) {
        return Integer.valueOf(string);
    }

    private String IntToString(int number) {
        return Integer.toString(number);
    }

    @FXML
    void CreateGame(ActionEvent event) throws IOException{
        for (int i = 0; i < playerlist.size(); i++) {
            fm.savePlayer(playerlist.get(i));
        }
    }

}