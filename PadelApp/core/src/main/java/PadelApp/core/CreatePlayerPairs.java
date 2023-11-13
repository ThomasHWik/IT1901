package padelapp.core;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for creating pairs of players for a Padel game.
 * It takes a list of players and creates pairs of players from it.
 * The number of players must be even and cannot be more than 10.
 * The class also provides a method to change the order of players and recreate
 * the pairs.
 * The pairs are stored in a list of PlayerPair objects.
 * The class also provides methods to get the list of player pairs and the list
 * of players.
 *
 * @param playerList      the list of players
 * @param playerPairslist the list of player pairs
 */
public class CreatePlayerPairs {

  private List<Player> playerList = new ArrayList<>();
  private List<PlayerPair> playerPairslist = new ArrayList<>();

  /**
   * Constructor for CreatePlayerPairs class.
   * Initializes the object by adding all players in the given list and creating
   * pairs of players.
   *
   * @param playerlist the list of players to be added and paired
   */
  public CreatePlayerPairs(List<Player> playerlist) {
    for (Player player : playerlist) {
      addPlayer(player);
    }
    createPlayerPairs(playerList);
  }

  /**
   * Adds a player to the player list.
   *
   * @param player the player to be added
   */
  private void addPlayer(Player player) {
    playerList.add(player);
  }

  /**
   * Creates pairs of players from a given list of players.
   * The number of players must be even and there can not be more than 10 players.
   *
   * @param players the list of players to create pairs from
   * @throws IllegalArgumentException if the number of players is odd or greater
   *                                  than 10
   */
  private void createPlayerPairs(List<Player> players) {

    if (playerList.size() % 2 != 0) {
      throw new IllegalArgumentException("The number of players must be even");
    }
    if (playerList.size() > 10) {
      throw new IllegalArgumentException("There can not be more then 10 players");
    }

    for (int i = 0; i < players.size(); i += 2) {
      Player player1 = players.get(i);
      Player player2 = players.get(i + 1);
      PlayerPair pair = new PlayerPair(player1, player2);
      playerPairslist.add(pair);
    }
  }

  /**
   * This method remakes the order of the players so that the player pairs will be
   * different.
   * It removes the first player from the player list and adds it to the end of
   * the list.
   * Then it creates new player pairs based on the updated player list.
   * Finally, it rearranges the player pairs so that the players will not play at
   * the same court.
   */
  public void remakePlayersOrder() {
    // changeing the order of the players so that the playersPairs will be different
    Player p = playerList.get(0);
    playerList.remove(0);
    playerList.add(p);

    playerPairslist = new ArrayList<>();
    createPlayerPairs(playerList);
    // So that the players will not play at the same court
    for (int i = 0; i < playerPairslist.size() / 2; i++) {
      PlayerPair pair = playerPairslist.get(0);
      playerPairslist.remove(i);
      playerPairslist.add(pair);
    }
  }

  /**
   * Returns a list of player pairs.
   *
   * @return the list of player pairs
   */
  public List<PlayerPair> getPlayerPairs() {
    return new ArrayList<>(this.playerPairslist);
  }

  /**
   * Returns the list of players.
   *
   * @return the list of players
   */
  public List<Player> getPlayerlist() {
    return new ArrayList<>(this.playerList);
  }

  /**
   * This method overrides the default toString() method to return a string
   * representation
   * of the CreatePlayerPairs object.
   * The string contains information about the PlayerPairslist and playerList
   * fields.
   *
   * @return a string representation of the CreatePlayerPairs object.
   */
  @Override
  public String toString() {
    return "CreatePlayerPairs [PlayerPairslist=" + playerPairslist + ", playerList=" + playerList + "]";
  }
}