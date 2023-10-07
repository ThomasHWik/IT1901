package FileManaging;

import java.io.File;
import java.io.IOException;

import Logic.Player;
import Logic.Scoreboard;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileManagerJson {

    private ObjectMapper om;
    private String filename;


    public FileManagerJson(String filename) {
        om = new ObjectMapper();
        this.filename = filename;

    }

    public void saveScoreboard(Scoreboard scoreboard) throws IOException, StreamWriteException {
        try {
            om.writeValue(new File(this.filename+".json"), scoreboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Scoreboard getScoreboard(String filename) {
        if (filename == null || filename.isEmpty() || !filename.endsWith(".json")) {
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
    
}