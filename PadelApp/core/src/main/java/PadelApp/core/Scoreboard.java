package PadelApp.core;

import PadelApp.json.FileManagerJson;

import java.util.ArrayList;

public class Scoreboard {
    private String filename;
    private ArrayList<Player> scorelist;

    public Scoreboard() {
        this.filename = "Scoreboard.json";
        this.scorelist = new ArrayList<Player>();
    }
    
    public Scoreboard(String filename) {
        if (filename != null && !filename.isEmpty()) {
            this.filename = filename;
            this.scorelist = new ArrayList<Player>();
            return;
        }
        throw new IllegalArgumentException("Invalid filename!");
    }

    public Scoreboard(ArrayList<Player> scorelist) {
        this.scorelist = new ArrayList<Player>();
        for (Player player : scorelist) {
                this.scorelist.add(player);
            }
    }
    
    public Scoreboard(String filename, ArrayList<Player> scorelist) {
        this.scorelist = new ArrayList<Player>();
        if (filename != null && !filename.isEmpty()) {
            this.filename = filename;
            for (Player player : scorelist) {
                this.scorelist.add(player);
            }
            return;
        }
        throw new IllegalArgumentException("Invalid filename!");
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void addPlayer(Player player) {
        scorelist.add(player);
    }

    public ArrayList<Player> getScorelist() {
        ArrayList<Player> scorelist = new ArrayList<>();
        for (Player player : this.scorelist) {
            scorelist.add(player);
        }
        return scorelist;
    }

    public void setScorelist(ArrayList<Player> scorelist) {
        this.scorelist = new ArrayList<>();
        for (Player player : scorelist) {
            this.scorelist.add(player);
        }
    }

    public void removePlayer(Player player) {
        scorelist.remove(player);
    }

    public String saveScoreboard() {
        try {
            FileManagerJson.saveScoreboard(this);
            return this.filename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
