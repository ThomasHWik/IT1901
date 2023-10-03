package app;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AppControllerScoreBoard {

    private PlayerComparator pc;
    private FileManager fm = new FileManager();
    private ArrayList<Player> scorelist;

    @FXML
    private TextArea scoreboard;

    public void createScoreboard() throws IOException {
        // fm.saveScoreboard(scorelist);
    }

    public void setScoreboard(ArrayList<Player> playerlist) {
        this.scorelist = playerlist;
        playerlist.sort(pc);
    }
}