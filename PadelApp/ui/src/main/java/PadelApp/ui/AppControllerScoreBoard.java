package PadelApp.ui;

import java.io.IOException;
import java.util.ArrayList;

import PadelApp.json.FileManagerJson;
import PadelApp.core.Leaderboard;
import PadelApp.core.Player;
import PadelApp.core.Scoreboard;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class AppControllerScoreBoard {

    private Leaderboard leaderboard;
    private Scoreboard scoreboard;

    @FXML
    private ListView<String> lbName, sbName;

    @FXML
    private ListView<Integer> lbWins, sbWins;

    @FXML
    public void initialize() throws IOException {
        leaderboard = FileManagerJson.getLeaderboard("Leaderboard");
        scoreboard = FileManagerJson.getLeaderboard("currentgame");
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        createLeaderboard();
        populateLeaderboard();
        populateScoreboard();
    }

    public void createLeaderboard() throws IOException {
        leaderboard.addScoreboard(scoreboard);
        leaderboard.sortLeaderboard();
        FileManagerJson.saveScoreboard(leaderboard);
    }

    private void populateLeaderboard() {
        lbName.getItems().clear();
        lbWins.getItems().clear();
        for (Player player : leaderboard.getTopPlayers(10)) {
            lbName.getItems().add(player.getName());
            lbWins.getItems().add(player.getWins());
        }
    }

    private void populateScoreboard() {
        sbName.getItems().clear();
        sbWins.getItems().clear();
        for (Player player : scoreboard.getTopPlayers(10)) {
            sbName.getItems().add(player.getName());
            sbWins.getItems().add(player.getWins());
        }
    }
}