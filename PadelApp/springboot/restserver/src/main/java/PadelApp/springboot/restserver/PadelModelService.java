package PadelApp.springboot.restserver;

import org.springframework.stereotype.Service;
import PadelApp.core.Leaderboard;
import PadelApp.core.Scoreboard;
import PadelApp.json.FileManagerJson;

import java.io.IOException;

@Service
public class PadelModelService {
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

    public Leaderboard getLeaderboard(String filename) {
        return FileManagerJson.getLeaderboard(filename);
    }

    public boolean addToLeaderboard(Scoreboard scoreboard) {
        Leaderboard leaderboard = FileManagerJson.getLeaderboard("Leaderboard.json");
        try {
            leaderboard.addScoreboard(scoreboard);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
