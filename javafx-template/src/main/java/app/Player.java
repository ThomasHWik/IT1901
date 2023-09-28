package app;

public class Player {

    private String Name;
    private int Age;
    private int wins;

    public Player(String name, int age) {
        Name = name;
        Age = age;
        wins=0;
    }

    public void addwins(){
        wins= wins+1;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

       
}