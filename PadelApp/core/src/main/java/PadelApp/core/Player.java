package core;

public class Player {

    private String name;
    private int age;
    private int wins;
    private int tlfNr;

    public Player() {
        this.name = "";
        this.age = 0;
        this.wins = 0;
        this.tlfNr = 11111111;
    }

    public Player(String name, int age) {
        setName(name);
        setAge(age);
        this.wins = 0;
        this. tlfNr= 11111111;
    }

    public Player(String name, int age, int tlfNr) {
        setName(name);
        setAge(age);
        setTlfNr(tlfNr);
        this.wins = 0;
    }


    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        this.age = age;
    }

    public void addwins() {
        wins+=1;
    }

    public void addWins(int wins) {
        this.wins += wins;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
    
    public int getWins() {
        return this.wins;
    }
    
    public void setWins(int wins) {
        if (wins < 0) {
            throw new IllegalArgumentException("Wins cannot be negative!");
        }
        this.wins = this.wins + wins;
    }

    public int getTlfNr() {
        return this.tlfNr;
    }

    public void setTlfNr(int tlfNr) {
        if (NumberManager.getDigits(tlfNr) != 8) {
            throw new IllegalArgumentException("Phone number must be 8 digits!");
        }
        this.tlfNr = tlfNr;
    }
}