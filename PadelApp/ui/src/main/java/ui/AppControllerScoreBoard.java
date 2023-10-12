package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import core.FileManagerJson;
import core.Leaderboard;
import core.Player;
import core.Scoreboard;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class AppControllerScoreBoard {

    private Leaderboard leaderboard;
    private Scoreboard scoreboard;

    @FXML
    ListView<String> name;

    @FXML
    ListView<Integer> wins;

    @FXML
    public void initialize() throws IOException {
        leaderboard = FileManagerJson.getLeaderboard();
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        createLeaderboard();
        populateTable();
    }

    public void createLeaderboard() throws IOException {
        leaderboard.addScoreboard(FileManagerJson.getScoreboard("currentgame"));
        leaderboard.sortLeaderboard();
    }

    public void setScoreboard(List<Player> playerlist) {
        scoreboard = new Scoreboard((ArrayList<Player>) playerlist);
    }

    private void populateTable() {
        name.getItems().clear();
        wins.getItems().clear();
        for (Player player : leaderboard.getTopPlayers(10)) {
            System.out.println(player.getName());
            name.getItems().add(player.getName());
            wins.getItems().add(player.getWins());
        }
    }
}