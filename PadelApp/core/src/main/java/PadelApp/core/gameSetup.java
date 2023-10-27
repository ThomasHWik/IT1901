package PadelApp.core;

import java.util.ArrayList;
import java.util.List;

public class gameSetup {

    private int singelCourt=2;
    private int doubleCourt=1;
    private List<PlayerPair> PlayerPairslist = new ArrayList<>();

    public gameSetup(int doubleCourt, List<PlayerPair> playerPairslist) {
        this.PlayerPairslist = playerPairslist;
    }

    private void courts(int ammount){
        if(PlayerPairslist.size()<ammount*2){
            throw new IllegalArgumentException("There has to be at least 4 players per double Court");
        }
        if(ammount>2) {
            throw new IllegalArgumentException("We only have 2 double courts");
        }
        if(PlayerPairslist.size()>5){
            throw new IllegalArgumentException("We don´t have enough cours for more than 10 palyers");
        }
        if(PlayerPairslist.size()==ammount*2){
            doubleCourt=ammount;
            singelCourt=0;
        }
        else if(ammount==0){
            singelCourt=PlayerPairslist.size();
        }
        else if(ammount==1){
            

        }
    
    }
    




    
}
