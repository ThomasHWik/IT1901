package FileManaging;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Logic.Player;

public class Getplayerlistoffile {
    
    public static List<Player> getListOfPlayers(String filePath) throws FileNotFoundException, IOException {

        List<Player> playerList = new ArrayList<>();
        boolean newSessionReached = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("New Session:")) {
                    // Reset the flag when a new session starts
                    newSessionReached = true;
                    playerList.clear();
                } else if (newSessionReached) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        int number = Integer.parseInt(parts[1].trim());
                        Player player = new Player(name, number);
                        playerList.add(player);
                    }
                }
            }
        }

        return playerList;
    }
}