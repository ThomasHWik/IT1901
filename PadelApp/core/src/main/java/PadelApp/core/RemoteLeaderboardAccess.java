package PadelApp.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

/**
 * RemoteLeaderboardAccess
 */
public class RemoteLeaderboardAccess {
    private final URI baseEndpoint;

    public RemoteLeaderboardAccess(URI baseEndpoint) {
        this.baseEndpoint = baseEndpoint;
    }

    public Leaderboard getLeaderboard() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(baseEndpoint)
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Parse the JSON response into a Leaderboard object
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(response.body(), Leaderboard.class);
            } else {
                // Handle error status codes if needed
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
           e.printStackTrace();
           
        }
        return null;
    }

    public boolean sendScoreboard(Scoreboard scoreboard) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String scoreboardJson = new ObjectMapper().writeValueAsString(scoreboard);

            HttpRequest request = HttpRequest.newBuilder(URI.create(baseEndpoint+"/addScoreboard"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(scoreboardJson))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("sent success");
                return true; // Scoreboard sent successfully
            } else {
                // Handle error status codes if needed
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions if necessary
        }

        return false; // Scoreboard sending failed
    }
}