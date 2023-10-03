package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private BufferedWriter bw;
    
    public FileManager() {
        try {
            bw = new BufferedWriter(new FileWriter("Players.txt", true));
            bw.write("\nNew Session:\n");
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePlayer(Player player) throws IOException {
        bw = new BufferedWriter(new FileWriter("Players.txt", true));

        StringBuilder sb = new StringBuilder();
        sb.append(player.getName() + ", ").append(player.getAge() + "\n");

        bw.write(sb.toString());
        bw.close();
    }

    public List<Player> getListOfPlayers( String filePath) throws FileNotFoundException, IOException{

        List<Player> playerList = new ArrayList<>();
        boolean newSessionReached = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("New Session:")) {
                    newSessionReached = true;
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