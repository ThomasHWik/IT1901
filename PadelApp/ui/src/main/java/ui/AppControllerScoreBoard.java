package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import FileManaging.FileManager;
import core.Player;
import core.PlayerComparator;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AppControllerScoreBoard {

    private PlayerComparator pc;
    private FileManager fm = new FileManager();
    private List<Player> scorelist;
    private ArrayList<Player> oldScorelist;
    private ArrayList<Player> newScorelist;

    @FXML
    private TextArea scoreboard;

    @FXML
    public void initialize() throws IOException {
        createScoreboard();
    }

    public void createScoreboard() throws IOException {
        oldScorelist = fm.loadScoreboard();

        scorelist.addAll(oldScorelist);
        scorelist.sort(pc);
        newScorelist = (ArrayList<Player>) scorelist.subList(0, 10);

        scoreboard.setText(fm.saveScoreboard(newScorelist));
    }

    public void setScorelist(List<Player> playerlist) {
        this.scorelist = playerlist;
    }
}