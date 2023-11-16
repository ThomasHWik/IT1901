package PadelApp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;


public class RemoteLeaderboardAccessTest {
    private RemoteLeaderboardAccess restApi;

    @BeforeEach
    @Test
    void constructorTest() {
        boolean check = false;
        try {
            restApi = new RemoteLeaderboardAccess(new URI("http:localhost:8080/api/padel"));
        } catch (Exception e) {
            check = true;
        }
        assertEquals(check, false);
    }

    @Test
    void getLeaderboardTest() {
        assertEquals(restApi.getLeaderboard(), null);
    }
}
