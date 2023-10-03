package app;

import java.util.ArrayList;
import java.util.List;

public class PlayerPair {
    
    private List<Player> playerList = new ArrayList<>();
    
    public PlayerPair(Player player1, Player player2) {}

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public List<PlayerPair> createPlayerPairs(List<Player> players) {
        List<PlayerPair> pairs = new ArrayList<>();

        if (playerList.size() % 2 != 0) {
            throw new IllegalArgumentException("the number of players must be even");
        }

        for (int i = 0; i < players.size(); i+=2) {
            Player player1 = players.get(i);
            Player player2 = players.get(i+1);
            PlayerPair pair = new PlayerPair(player1, player2);
            pairs.add(pair);
        }

        return pairs;
    }
}