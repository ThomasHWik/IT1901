package app;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

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
}