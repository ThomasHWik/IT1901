package PadelApp.core;

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
            throw new IllegalArgumentException("The number of players must be even");
        }
        if (playerList.size()>10){
            throw new IllegalArgumentException("There can not be more then 10 players");
        }

        for (int i = 0; i < players.size(); i+=2){
            Player player1 = players.get(i);
            Player player2 = players.get(i+1);
            PlayerPair pair = new PlayerPair(player1, player2);
            PlayerPairslist.add(pair);
        }
    }

    public void remakePlayersOrder(){
        //changeing the order of the players so that the playersPairs will be different
        Player p = playerList.get(0);
        playerList.remove(0);
        playerList.add(p);

        PlayerPairslist= new ArrayList<>();
        createPlayerPairs(playerList);
        //So that the players will not play at the same court 
        for (int i = 0; i < PlayerPairslist.size()/2; i++) {
            PlayerPair pair = PlayerPairslist.get(0);
            PlayerPairslist.remove(i);
            PlayerPairslist.add(pair); 
        }
    }

    public List<PlayerPair> getPlayerPairs(){
        return PlayerPairslist;
    }

    public List<Player> getPlayerlist(){
        return playerList;
    }

    @Override
    public String toString() {
        return "CreatePlayerPairs [PlayerPairslist=" + PlayerPairslist + ", playerList=" + playerList + "]";
    }

    
}