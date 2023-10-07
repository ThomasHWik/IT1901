package Logic;

import java.util.ArrayList;

public class Scoreboard {
    String filename;
    ArrayList<Player> scorelist;
    
    public Scoreboard(String filename) {
        if (filename != null && !filename.isEmpty()) {
            this.filename = filename;
            this.scorelist = new ArrayList<Player>();
            return;
        }
        throw new IllegalArgumentException("Invalid filename!");
    }

    public String getFilename() {
        return this.filename;
    }

    public void addPlayer(Player player) {
        scorelist.add(player);
    }

    public ArrayList<Player> getScorelist() {
        return this.scorelist;
    }

    public void removePlayer(Player player) {
        scorelist.remove(player);
    }

    public String saveScoreboard() {
        try {
            FileManaging.FileManagerJson.saveScoreboard(this);
            return this.filename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
