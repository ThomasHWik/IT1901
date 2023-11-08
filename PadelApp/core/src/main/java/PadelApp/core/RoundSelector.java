package PadelApp.core;

public class RoundSelector {
    
    private int numberOfRounds;

    public RoundSelector(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds(){
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        if (numberOfRounds < 1 || numberOfRounds > 10){
            throw new IllegalArgumentException("Not valid input!");
        }
        this.numberOfRounds = numberOfRounds;
    }
   
}
