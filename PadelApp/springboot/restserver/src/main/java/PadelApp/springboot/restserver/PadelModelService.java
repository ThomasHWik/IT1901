package PadelApp.springboot.restserver;

import org.springframework.stereotype.Service;
import PadelApp.core.Leaderboard;
import PadelApp.core.Scoreboard;
import PadelApp.json.FileManagerJson;

import java.io.IOException;

@Service
public class PadelModelService {
    private String currentFilename = "Leaderboard";

    public boolean saveLeaderboard(Leaderboard leaderboard) {
        try {
            FileManagerJson.saveScoreboard(leaderboard);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Scoreboard getScoreboard(String filename) {
        return FileManagerJson.getScoreboard(filename);
    }

    public Leaderboard getLeaderboard() {
        return FileManagerJson.getLeaderboard(currentFilename);
    }

    public boolean addToLeaderboard(Scoreboard scoreboard) {
        Leaderboard leaderboard = FileManagerJson.getLeaderboard(currentFilename);
        try {
            if (leaderboard != null) {
            leaderboard.addScoreboard(scoreboard);
            } else {
            leaderboard = (Leaderboard) scoreboard;
            }
            saveLeaderboard(leaderboard);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void initialize() {
        Leaderboard leaderboard = new Leaderboard();
        saveLeaderboard(leaderboard);
    }
}
