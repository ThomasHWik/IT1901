package FileManaging;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Logic.Player;
import Logic.PlayerComparator;

public class FileManager {

    private BufferedWriter bw;
    private BufferedReader br;
    private PlayerComparator pc;
    
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

    public String saveScoreboard(ArrayList<Player> scorelist) throws IOException {
        File sbFile = new File("Scoreboard.txt");
        bw = new BufferedWriter(new FileWriter(sbFile));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scorelist.size(); i++) {
            switch (i++) {
                case 1:
                    sb.append(i + "st\t");
                    break;
                case 2:
                    sb.append(i + "nd\t");
                    break;
                case 3:
                    sb.append(i + "rd\t");
                    break;
                default:
                    sb.append(i + "th\t");
                    break;
            }

            Player player = scorelist.get(i--);
            sb.append(player.getName() + "\t").append(player.getWins() + "\n");
        }

        bw.write(sb.toString());
        bw.close();

        return sb.toString();
    }

    public ArrayList<Player> loadScoreboard() throws IOException {
        br = new BufferedReader(new FileReader("Scoreboard.txt"));

        ArrayList<Player> oldScorelist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] playerInfo = br.readLine().split("\t");
            Player player = new Player(playerInfo[1], 0);
            player.setWins(Integer.valueOf(playerInfo[2]));
            oldScorelist.add(player);
        }

        br.close();

        oldScorelist.sort(pc);
        return oldScorelist;
    }

    public List<Player> getListOfPlayers(String filePath) throws FileNotFoundException, IOException {

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