package PadelApp.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.ObjectMapper;
import PadelApp.core.Scoreboard;
import PadelApp.core.Leaderboard;


/**
 * Class with static methods for reading and writing JSON files.
 */
public class FileManagerJson {
    /**
     * Saves the given scoreboard object to a JSON file.
     * 
     * @param scoreboard the scoreboard object to be saved
     * @throws IOException if an I/O error occurs while writing to the file
     * @throws StreamWriteException if an error occurs while writing to the file
     */
    static public void saveScoreboard(Scoreboard scoreboard) throws IOException, StreamWriteException {
        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(new File(scoreboard.getFilename()), scoreboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a Scoreboard object from a JSON file.
     * 
     * @param filename the name of the JSON file to read from
     * @return the Scoreboard object read from the file, or null if the file does not exist or is empty
     */
    static public Scoreboard getScoreboard(String filename) {
        if (filename == null || filename.isEmpty()) {
            return null;
        }   
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }
        ObjectMapper om = new ObjectMapper();
        try {
            return om.readValue(file, Scoreboard.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads a Leaderboard object from a JSON file.
     * 
     * @param filename the path of the JSON file to read from
     * @return the Leaderboard object read from the file, or null if the file does not exist or cannot be read
     */
    static public Leaderboard getLeaderboard(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }
        ObjectMapper om = new ObjectMapper();
        try {
            return om.readValue(file, Leaderboard.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}