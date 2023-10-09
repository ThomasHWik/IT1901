package Logic;

public class Player {

    private String name;
    private int age;
    private double wins;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.wins = 0.0;
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
}