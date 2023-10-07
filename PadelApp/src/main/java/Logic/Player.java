package Logic;

public class Player {

    private String name;
    private int age;
    private int wins;
    private int tlfNr;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.wins = 0;
    }

    public void addwins() {
        wins++;
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
        this.wins = wins;
    }

    public int getTlfNr() {
        return this.tlfNr;
    }

    public void setTlfNr(int tlfNr) {
        this.tlfNr = tlfNr;
    }
}