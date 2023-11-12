package PadelApp.core;

/**
 * The Player class represents a player in a game.
 * It contains the player's name, age, number of wins, and phone number.
 * The class provides methods to set and get the player's
 * name, age, number of wins, and phone number.
 * It also provides methods to increment the number of wins,
 * and to set the phone number with validation.
 * 
 * @param name the name of the player
 * @param age the age of the player
 * @param wins the number of wins of the player
 * @param tlfNr the phone number of the player
 */
public class Player {

    private String name;
    private int age;
    private int wins;
    private int tlfNr;


    /**
     * Constructs a new Player object with default values.
     */
    public Player() {
        this.name = "";
        this.age = 0;
        this.wins = 0;
        this.tlfNr = 11111111;
    }

    /**
     * Constructs a new Player object with the given name and age.
     * Sets the initial number of wins to 0 and the phone number to 11111111.
     * 
     * @param name the name of the player
     * @param age the age of the player
     */
    public Player(String name, int age) {
        setName(name);
        setAge(age);
        this.wins = 0;
        this. tlfNr = 11111111;
    }

    /**
     * Constructs a new Player object with the given name, age and phone number.
     * 
     * @param name the name of the player
     * @param age the age of the player
     * @param tlfNr the phone number of the player
     */
    public Player(String name, int age, int tlfNr) {
        setName(name);
        setAge(age);
        setTlfNr(tlfNr);
        this.wins = 0;
    }

    /**
     * Constructs a new Player object with the given name, age, number of wins and telephone number.
     * 
     * @param name the name of the player
     * @param age the age of the player
     * @param wins the number of wins of the player
     * @param tlfNr the telephone number of the player
     */
    public Player(String name, int age, int wins, int tlfNr) {
        setName(name);
        setAge(age);
        setWins(wins);
        setTlfNr(tlfNr);
    }

    /**
     * Constructs a new Player object with the same values as another Player object.
     *
     * @param player the other Player object you take the values from
     */
    public Player(Player player) {
        setName(player.getName());
        setAge(player.getAge());
        setWins(player.getWins());
        setTlfNr(player.getTlfNr());
    }

    /**
     * Sets the name of the player.
     * 
     * @param name the name of the player
     * 
     * @throws IllegalArgumentException if the name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }

    /**
     * Sets the age of the player.
     * 
     * @param age the age of the player to be set
     * 
     * @throws IllegalArgumentException if the age is negative
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        this.age = age;
    }

    /**
     * Increases the number of wins for the player by 1.
     */
    public void addwins() {
        this.wins += 1;
    }

    /**
     * Adds the specified number of wins to the player's current win count.
     *
     * @param wins the number of wins to add to the player's current win count
     */
    public void addWins(int wins) {
        this.wins += wins;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the age of the player.
     *
     * @return the age of the player
     */
    public int getAge() {
        return this.age;
    }
    
    /**
     * Returns the number of wins of the player.
     *
     * @return the number of wins of the player
     */
    public int getWins() {
        return this.wins;
    }
    
    /**
     * Sets the number of wins for the player.
     * 
     * @param wins the number of wins to set
     * 
     * @throws IllegalArgumentException if the number of wins is negative
     */
    public void setWins(int wins) {
        if (wins < 0) {
            throw new IllegalArgumentException("Wins cannot be negative!");
        }
        this.wins = this.wins + wins;
    }

    /**
     * Returns the phone number of the player.
     *
     * @return the phone number of the player
     */
    public int getTlfNr() {
        return this.tlfNr;
    }

    /**
     * Sets the phone number of the player.
     * 
     * @param tlfNr the phone number to set
     * 
     * @throws IllegalArgumentException if the phone number is not valid
     */
    public void setTlfNr(int tlfNr) {
        int digits = NumberManager.getDigits(tlfNr);
        int firstDigit = NumberManager.getFirstDigit(tlfNr);
        if (digits != 8 || (firstDigit != 9 && firstDigit != 4)) {
            throw new IllegalArgumentException("Phone must be valid");
        }
        this.tlfNr = tlfNr;
    }

    /**
     * Returns a string representation of the Player object.
     * 
     * @return a string representation of the Player object
     */
    @Override
    public String toString() {
        return "Player [name=" + name + ", wins=" + wins + "]";
    }
}