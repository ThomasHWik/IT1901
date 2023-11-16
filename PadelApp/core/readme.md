# Core module
The core folder handles the domain logic and local storage

## The domain logic
In the Padelapp project we need classes that can registrate players who play against each other and gives them points for wins, to create scoreboard and leaderboard. Therefor we have built our domain logic around the classes CreatePlayerPairs.java, gameSetup.java, Leaderboard.java, NumberManager.java, Player.java, PlayerComparator.java, PlayerPair.java, RoundSelector.java and Scoreboard.java.

* **core/CreatePlayerPairs:** this class creates a list of playerpairs
* **core/gameSetup:** this class sets up single and double courts
* **core/Leaderboard:** this class handles the logic for leaderboard and creates a list of the players
* **core/NumberManager:** this class provides methods to calculate the number of digits in an integer and the first digit of a given integer.
* **core/Player:** this class create a player and have getters and setters for name, age, wins and phonenumber
* **core/PlayerComparator:** this class implements the Comparator interface to compare two Player objects based om their number of wins
* **core/PlayerPair:** this class creates a list of a playerpair
* **core/RoundSelector:** this class contains getter and setter for number of rounds
* **core/Scoreboard:** this class handles the logic for scoreboard and creates a list of the players

## File storage
We want the be able to have a leaderboard that shows the number of wins for all the players that have ever been registered in the app, regardless of wether you close the application or not. To achieve this, we have a class that handles reading and writing JSON files.

* **json/FileManagerJson.java:** method for saving a given scoreboard object to a JSON file, and method for reading a scoreboard and leaderboard object from a JSON file

## Class diagram
Here is a class diagram of how the classes are connected in core.