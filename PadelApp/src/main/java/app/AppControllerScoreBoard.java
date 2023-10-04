package app;

import java.io.IOException;
import java.util.ArrayList;

import FileManaging.FileManager;
import Logic.Player;
import Logic.PlayerComparator;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AppControllerScoreBoard {

    private PlayerComparator pc;
    private FileManager fm = new FileManager();
    private ArrayList<Player> scorelist;
    private ArrayList<Player> oldScorelist;
    private ArrayList<Player> newScorelist;

    @FXML
    private TextArea scoreboard;

    public void createScoreboard() throws IOException {
        oldScorelist = fm.loadScoreboard();

        scorelist.addAll(oldScorelist);
        scorelist.sort(pc);
        newScorelist = (ArrayList<Player>) scorelist.subList(0, 10);

        scoreboard.setText(fm.saveScoreboard(newScorelist));
    }

    public void setScorelist(ArrayList<Player> playerlist) {
        this.scorelist = playerlist;
    }
}