package core;

import java.util.ArrayList;
import java.util.List;

public class CreatePlayerPairs {
    
    private List<Player> playerList = new ArrayList<>();
    private List<PlayerPair> PlayerPairslist = new ArrayList<>();

    public CreatePlayerPairs(List<Player> playerlist) {
        for (Player player : playerlist) {
            addPlayer(player);
        }
        createPlayerPairs(playerList);
    }

    private void addPlayer(Player player) {
        playerList.add(player);
    }

    private void createPlayerPairs(List<Player> players) {

        if (playerList.size() % 2 != 0){
            throw new IllegalArgumentException("the number of players must be even");
        }
        if (playerList.size()>22){
            throw new IllegalArgumentException("There can not be more then 22 players");
        }

        for (int i = 0; i < players.size(); i+=2){
            Player player1 = players.get(i);
            Player player2 = players.get(i+1);
            PlayerPair pair = new PlayerPair(player1, player2);
            PlayerPairslist.add(pair);
        }
    }

    public List<PlayerPair> getPlayerPairs(){
        return PlayerPairslist;
    }
}