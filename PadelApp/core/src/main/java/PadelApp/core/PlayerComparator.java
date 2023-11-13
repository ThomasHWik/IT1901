package padelapp.core;

import java.io.Serializable;
import java.util.Comparator;

public class PlayerComparator implements Comparator<Player>, Serializable {

  /**
   * This class implements the Comparator interface to compare two Player objects
   * based on their number of wins.
   * The compare method returns a negative integer, zero, or a positive integer
   * as the first argument is greater than, equal to, or less than the second.
   *
   * @param o1 the first Player object to be compared
   * @param o2 the second Player object to be compared
   * @return a negative integer, zero, or a positive integer based on the number
   *         of wins
   * @see java.util.Comparator
   */
  @Override
  public int compare(Player o1, Player o2) {
    return o2.getWins() - o1.getWins();
  }
}