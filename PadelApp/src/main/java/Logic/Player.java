package Logic;

public class Player {

    private String name;
    private int age;
    private double wins;
    private int tlfNr;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.wins = 0;
        this.tlfNr = 0;
    }

    public Player() {
        this.name = "";
        this.age = 0;
        this.wins = 0;
        this.tlfNr = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        this.age = age;
    }

    public void addwins() {
        wins+=1.0;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
    
    public double getWins() {
        return this.wins;
    }
    
    public void setWins(double wins) {
        this.wins = this.wins + wins;
    }

    public int getTlfNr() {
        return this.tlfNr;
    }

    public void setTlfNr(int tlfNr) {
        this.tlfNr = tlfNr;
    }
}