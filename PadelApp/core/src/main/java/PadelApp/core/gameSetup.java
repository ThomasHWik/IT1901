package PadelApp.core;

import java.util.ArrayList;
import java.util.List;

public class gameSetup {

    private int maxSingle=3;
    private int maxDouble=2;
    private int maxPlayerpairs=5;

    private int singelCourt;
    private int doubleCourt;
    private List<PlayerPair> PlayerPairslist = new ArrayList<>();

    public gameSetup(int doubleCourt, List<PlayerPair> playerPairslist) {
        this.PlayerPairslist = playerPairslist;
        courts(doubleCourt);
    }

    private void courts(int ammount){
    //sets up the ammount of courts needed after you choose how many double courts you want
        if(PlayerPairslist.size()<ammount*2){
            throw new IllegalArgumentException("There has to be at least 4 players per double Court");
        }
        if(ammount>maxDouble) {
            throw new IllegalArgumentException("We only have "+ maxDouble+" double courts");
        }
        if(PlayerPairslist.size()>maxPlayerpairs){
            throw new IllegalArgumentException("We don´t have enough courts for more than"+ maxPlayerpairs*2 + "players");
        }
       if(ammount==0){
            if(PlayerPairslist.size()>maxSingle)throw new IllegalArgumentException("There is only " + maxSingle + " avalable single courts");
            doubleCourt=0;
            singelCourt=PlayerPairslist.size();
        }
        else{
            doubleCourt=ammount;
            singelCourt=PlayerPairslist.size() - ammount*2;
        }
    
    }

    public int getSingle(){
        return singelCourt;
    }

    public int getDouble(){
        return doubleCourt;
    }
    
    
}
