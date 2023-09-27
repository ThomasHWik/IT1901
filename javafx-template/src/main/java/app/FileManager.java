package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
}