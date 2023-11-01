package PadelApp.ui;

import java.io.IOException;

import PadelApp.json.FileManagerJson;
import PadelApp.core.Leaderboard;
import PadelApp.core.Player;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class AppControllerScoreBoard {

    private Leaderboard leaderboard;

    @FXML
    ListView<String> name;

    @FXML
    ListView<Integer> wins;

    @FXML
    public void initialize() throws IOException {
        leaderboard = FileManagerJson.getLeaderboard("Leaderboard");
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        createLeaderboard();
        populateTable();
    }

    public void createLeaderboard() throws IOException {
        leaderboard.addScoreboard(FileManagerJson.getScoreboard("currentgame"));
        leaderboard.sortLeaderboard();
        FileManagerJson.saveScoreboard(leaderboard);
    }

    private void populateTable() {
        name.getItems().clear();
        wins.getItems().clear();
        for (Player player : leaderboard.getTopPlayers(10)) {
            name.getItems().add(player.getName());
            wins.getItems().add(player.getWins());
        }
    }
}