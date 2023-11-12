package PadelApp.core;

import PadelApp.json.FileManagerJson;
import java.util.ArrayList;
import java.util.List;

/**
 * The Scoreboard class represents a scoreboard for a PadelApp game.
 * It contains a filename and an ArrayList of Player objects.
 * The class provides methods to set and get the filename and the ArrayList of Player objects.
 * It also provides methods to add and remove players from the scoreboard,
 * and to save the scoreboard to a JSON file.
 * 
 * @param filename the name of the file to be used for storing the scoreboard data
 * @param scorelist the list of players in the scoreboard
 */
public class Scoreboard {
    /**
     * The name of the JSON file used to store the scoreboard data.
     */
    private String filename; 

    /**
     * The list of players in the scoreboard.
     */
    private ArrayList<Player> scorelist;
        
    /**
     * Constructs a new Scoreboard object with an empty list of players and a default filename.
    */
    public Scoreboard() {
       this.filename = "Scoreboard.json";
        this.scorelist = new ArrayList<Player>();
    }
    
    
    /**
     * Constructs a new Scoreboard object with the given filename.
     *
     * @param filename the name of the file to be used for storing the scoreboard data
     * @throws IllegalArgumentException if the filename is null or empty
     */
    public Scoreboard(String filename) {
        if (filename != null && !filename.isEmpty()) {
            this.filename = filename;
            this.scorelist = new ArrayList<Player>();
            return;
        }
        throw new IllegalArgumentException("Invalid filename!");
    }

    /**
     * Constructs a new Scoreboard object with the given list of players.
     *
     * @param scorelist the list of players to be added to the scoreboard
     */
    public Scoreboard(ArrayList<Player> scorelist) {
        this.scorelist = new ArrayList<Player>();
        for (Player player : scorelist) {
            this.scorelist.add(player);
        }
    }
    
    /**
     * Constructs a Scoreboard object with a given filename and a list of players' scores.
     *
     * @param filename the name of the file to be used for storing the scores
     * @param scorelist the list of players' scores to be added to the scoreboard
     * @throws IllegalArgumentException if the filename is null or empty
     */
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

    /**
     * Returns the filename of the scoreboard.
     *
     * @return the filename of the scoreboard
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Sets the filename of the scoreboard.
     *
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Adds a player to the scoreboard.
     *
     * @param player the player to be added to the scoreboard
     */
    public void addPlayer(Player player) {
        scorelist.add(player);
    }

    /**
     * Returns an ArrayList of Player objects representing the current scorelist.
     *
     * @return ArrayList<Player> representing the current scorelist.
     */
    public ArrayList<Player> getScorelist() {
        ArrayList<Player> scorelist = new ArrayList<>();
        for (Player player : this.scorelist) {
            scorelist.add(player);
        }
        return scorelist;
    }

    /**
     * Sets the scorelist of the scoreboard.
     *
     * @param scorelist the ArrayList of Player objects to set as the scorelist
     */
    public void setScorelist(ArrayList<Player> scorelist) {
        this.scorelist = new ArrayList<>();
        for (Player player : scorelist) {
            this.scorelist.add(player);
        }
    }

    /**
     * Removes the given player from the scoreboard.
     *
     * @param player the player to be removed from the scoreboard
     */
    public void removePlayer(Player player) {
        scorelist.remove(player);
    }

    /**
     * Saves the current scoreboard to a JSON file.
     *
     * @return the filename of the saved scoreboard
     */
    public String saveScoreboard() {
        try {
            FileManagerJson.saveScoreboard(this);
            return this.filename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Player> getTopPlayers(int n) {
        PlayerComparator pc = new PlayerComparator();
        List<Player> lbList = this.getScorelist().stream()
                                                 .sorted(pc)
                                                 .limit(n)
                                                 .toList();

        return lbList;
    }
}