package app;

import java.util.ArrayList;
import java.util.List;

public class CreatePlayerPairs {
    
    private List<Player> playerList = new ArrayList<>();
    private List<PlayerPair> PlayerPairslist;

    
    
    public CreatePlayerPairs(List<Player> playerlist) {
        for (int i = 0; i < playerlist.size(); i++) {
            addPlayer(playerlist.get(i));
        }
        createPlayerPairs(playerList);
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    private List<PlayerPair> createPlayerPairs(List<Player> players){
        List<PlayerPair> pairs = new ArrayList<>();

        if (playerList.size() % 2 != 0){
            throw new IllegalArgumentException("the number of players must be even");
        }

        for (int i = 0; i < players.size(); i+=2){
            Player player1 = players.get(i);
            Player player2 = players.get(i+1);
            PlayerPair pair = new PlayerPair(player1, player2);
            pairs.add(pair);
        }
        return pairs;
    }

    public List<PlayerPair> getPlayerPairs(){
        return PlayerPairslist;
    }

    

}