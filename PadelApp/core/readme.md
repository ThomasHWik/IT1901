# Core module
The core folder handles the domain logic and local storage

## The domain logic
In the Padelapp project we need classes that can registrate players who play against each other and gives them points for wins, to create scoreboard and leaderboard. Therefor we have built our domain logic around the classes CreatePlayerPairs.java, gameSetup.java, Leaderboard.java, NumberManager.java, Player.java, PlayerComparator.java, PlayerPair.java, RoundSelector.java and Scoreboard.java.

* **core/CreatePlayerPairs:** this class creates a list of playerpairs
* **core/gameSetup:** this class sets up single and double courts
* **core/Leaderboard:** this class handles the logic for leaderboard and creates a list of the players
* **core/NumberManager:**
* **core/Player:** this class create a player and have getters and setters for name, age and phonenumber
* **core/PlayerComparator:**
* **core/PlayerPair:** this class creates a list of a playerpair
* **core/RoundSelector:** this class contains getter and setter for number of rounds
* **core/Scoreboard:** this class handles the logic for scoreboard and creates a list of the players

## File storage


## Class diagram
Here is a class diagram of how the classes are connected in core.