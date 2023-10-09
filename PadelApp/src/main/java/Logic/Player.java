package Logic;

public class Player {

    private String name;
    private int age;
    private int wins;
    private int tlfNr;

    public Player(String name, int age) {
        setName(name);
        setAge(age);
        this.wins = 0;
        this. tlfNr= 0;
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
    
    public int getWins() {
        return this.wins;
    }
    
    public void setWins(int wins) {
        this.wins = this.wins + wins;
    }

    public int getTlfNr() {
        return this.tlfNr;
    }

    public void setTlfNr(int tlfNr) {
        this.tlfNr = tlfNr;
    }
}