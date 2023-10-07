package FileManaging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Logic.Player;
import Logic.Scoreboard;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileManagerJson {

    private ObjectMapper om;

    public FileManagerJson() {
        om = new ObjectMapper();
    }

    public void savePlayer(Player player, Scoreboard scoreboard) throws IOException, StreamWriteException {
        try {
            om.writeValue(new File("scoreboard.json"), getScoreboard());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scoreboard getScoreboard() {
        return null;
    }
    
}