package PadelApp.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a pair of players in a Padel game.
 *
 * @param player1 the first player in the pair
 * @param player2 the second player in the pair
 */
public class PlayerPair {

  private Player player1;
  private Player player2;

  /**
   * Constructs a new PlayerPair object with the given players.
   *
   * @param player1 the first player in the pair
   * @param player2 the second player in the pair
   */
  public PlayerPair(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
  }

  /**
   * Creates a list of player pairs from a list of players.
   * The number of players must be even.
   *
   * @param players the list of players to create pairs from
   * @return a list of player pairs
   * @throws IllegalArgumentException if the number of players is odd
   */
  public List<PlayerPair> createPlayerPairs(List<Player> players) {
    List<PlayerPair> pairs = new ArrayList<>();

    if (players.size() % 2 != 0) {
      throw new IllegalArgumentException("the number of players must be even");
    }

    for (int i = 0; i < players.size(); i += 2) {
      Player player1 = players.get(i);
      Player player2 = players.get(i + 1);
      PlayerPair pair = new PlayerPair(player1, player2);
      pairs.add(pair);
    }

    return pairs;
  }

  /**
   * Returns the first player in the player pair.
   *
   * @return the first player in the player pair
   */
  public Player getPlayer1() {
    return new Player(player1);
  }

  /**
   * Returns the second player in the player pair.
   *
   * @return the second player in the player pair
   */
  public Player getPlayer2() {
    return new Player(player2);
  }
}