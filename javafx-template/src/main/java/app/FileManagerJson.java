package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileManagerJson {

    private ObjectMapper om;

    public FileManagerJson() {
        om = new ObjectMapper();
    }

    public void savePlayer(Player player, Scoreboard scoreboard) throws IOException, StreamWriteException {
        //add player to the scoreboard

        //create scoreboard file from scoreboard object
        
        try {
            om.writeValue(new File("scoreboard.json"), getScoreboard());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scoreboard getScoreboard() throws Exception {
        return null;
    }
    
}