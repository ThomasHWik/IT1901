package app.LogicTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Logic.Player;

public class PadelTest {

    @Test
    void testPlayer() {

        Player player= new Player("Jon", 23);

        Assertions.assertTrue(player.getName() =="Jon");
        Assertions.assertTrue(player.getAge() == 23);
    }
}