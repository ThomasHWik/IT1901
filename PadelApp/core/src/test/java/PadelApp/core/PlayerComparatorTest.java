package PadelApp.core;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PadelApp.core.PlayerComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import PadelApp.core.Player;

public class PlayerComparatorTest {
    private Player player1;
    private Player player2;
    private PlayerComparator comparator;

    @BeforeEach
    void setUp() {
        player1 = new Player("Oscar", 22, 50505050);
        player2 = new Player("Kevin", 31, 60606060);
        comparator = new PlayerComparator();
    }

    @Test
    void testCompare() {
        player1.setWins(5);
        player2.setWins(8);
        int expectedComparisonValue = player2.getWins() - player1.getWins();
        int actualValue = comparator.compare(player1, player2);
        // Compare value returned from compare-function with expected value
        assertEquals(expectedComparisonValue, actualValue);
    }
}
