package app;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class Player {

    private String Name;
    private int Age;
    private int Grade;

 
    public Player(String name, int age, int grade) {
        Name = name;
        Age = age;
        Grade = grade;
    }

    public String getName(){
        return Name;
    }

    public int getAge(){
        return Age;
    }

    public int getGrade(){
        return Grade;
    }

    
}
