package padelapp.core;

/**
 * The RoundSelector class represents a selector for the number of rounds in a
 * tournament.
 *
 * @param numberOfRounds the number of rounds to be selected
 */
public class RoundSelector {

  private int numberOfRounds;

  /**
   * Constructs a RoundSelector object with the specified number of rounds.
   *
   * @param numberOfRounds the number of rounds to be selected
   */
  public RoundSelector(int numberOfRounds) {
    this.numberOfRounds = numberOfRounds;
  }

  /**
   * Returns the number of rounds.
   *
   * @return the number of rounds
   */
  public int getNumberOfRounds() {
    return numberOfRounds;
  }

  /**
   * Sets the number of rounds for the tournament.
   *
   * @param numberOfRounds the number of rounds to be set
   * @throws IllegalArgumentException if the input is less than 1 or greater than
   *                                  10
   */
  public void setNumberOfRounds(int numberOfRounds) {
    if (numberOfRounds < 1 || numberOfRounds > 10) {
      throw new IllegalArgumentException("Not valid input!");
    }
    this.numberOfRounds = numberOfRounds;
  }
}