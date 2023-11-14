package PadelApp.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The GameSetup class represents the setup of a Padel game.
 * It contains the maximum number of players allowed in a single game,
 * the maximum number of double courts,
 * and the maximum number of player pairs allowed in a game.
 * It also contains the number of single and double courts needed for a game,
 * and a list of player pairs.
 *
 * @param maxSingle       The maximum number of single courts allowed in a game.
 * @param maxDouble       The maximum number of double courts allowed in a game.
 * @param maxPlayerpairs  The maximum number of player pairs allowed in a game.
 * @param singelCourt     The number of single courts needed for a game.
 * @param doubleCourt     The number of double courts needed for a game.
 * @param PlayerPairslist The list of player pairs.
 */
public class GameSetup {

  private int maxSingle = 5;
  private int maxDouble = 2;
  private int maxPlayerpairs = 5;

  private int singelCourt;
  private int doubleCourt;
  private List<PlayerPair> PlayerPairslist = new ArrayList<>();

  /**
   * Constructor for the GameSetup class.
   *
   * @param doubleCourt     the number of double courts available for the game
   * @param playerPairslist a list of player pairs for the game
   */
  public GameSetup(int doubleCourt, List<PlayerPair> playerPairslist) {
    this.PlayerPairslist = playerPairslist;
    courts(doubleCourt);
  }

  /**
   * Sets up the amount of courts needed after choosing how many double courts are
   * required.
   * Throws an IllegalArgumentException if the number of players is less than 4
   * per double court,
   * or if the number of double courts exceeds the maximum available,
   * or if the number of player pairs exceeds the maximum allowed.
   *
   * @param ammount the number of double courts required
   * @throws IllegalArgumentException if the number of players and courts do not
   *                                  add up
   */
  private void courts(int ammount) {
    // sets up the ammount of courts needed after you choose how many double courts
    // you want
    if (PlayerPairslist.size() < ammount * 2) {
      throw new IllegalArgumentException("There has to be at least 4 players per double Court");
    }
    if (ammount > maxDouble) {
      throw new IllegalArgumentException("We only have " + maxDouble + " double courts");
    }
    if (PlayerPairslist.size() > maxPlayerpairs) {
      throw new IllegalArgumentException("We don't have enough courts for more than" + maxPlayerpairs * 2 + "players");
    }
    if (ammount == 0) {
      if (PlayerPairslist.size() > maxSingle) {
        throw new IllegalArgumentException("There is only " + maxSingle + " avalable single courts");
      }
      doubleCourt = 0;
      singelCourt = PlayerPairslist.size();
    } else {
      doubleCourt = ammount;
      singelCourt = PlayerPairslist.size() - ammount * 2;
    }
  }

  /**
   * Returns the number of single courts available for game setup.
   *
   * @return the number of single courts available
   */
  public int getSingle() {
    return singelCourt;
  }

  /**
   * Returns the value of the doubleCourt variable.
   *
   * @return the value of the doubleCourt variable.
   */
  public int getDouble() {
    return doubleCourt;
  }
}