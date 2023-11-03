package PadelApp.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import PadelApp.core.Scoreboard;
import PadelApp.core.Leaderboard;

public class FileManagerJson {
    static public void saveScoreboard(Scoreboard scoreboard) throws IOException, StreamWriteException {
        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(new File(scoreboard.getFilename()), scoreboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    /**
     * 
     * @param scoreboard object to serialize as json
     * @return json string of the serialized object
     * @throws JsonProcessingException when the serialization fails
     */

    static public String getJsonString(Leaderboard scoreboard) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(scoreboard);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}