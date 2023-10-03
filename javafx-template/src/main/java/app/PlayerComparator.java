package app;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
        return o2.getWins() - o1.getWins();
    }
}