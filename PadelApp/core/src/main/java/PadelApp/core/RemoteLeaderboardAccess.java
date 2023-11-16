package PadelApp.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * This class facilitates access to a remote leaderboard system through HTTP
 * requests.
 * It allows fetching the leaderboard and sending scoreboard data to the remote
 * server.
 */
public class RemoteLeaderboardAccess {
  private final URI baseEndpoint;
  private final HttpClient client;

  /**
   * Initializes a RemoteLeaderboardAccess object with the base URI endpoint.
   *
   * @param baseEndpoint the base URI endpoint of the remote leaderboard system
   */
  public RemoteLeaderboardAccess(URI baseEndpoint) {
    this.baseEndpoint = baseEndpoint;
    this.client = HttpClient.newHttpClient();
  }

  /**
   * Fetches the current leaderboard from the remote server.
   *
   * @return the Leaderboard object retrieved from the remote server, or null in
   *         case of an error
   */
  public Leaderboard getLeaderboard() {
    try {
      HttpRequest request = HttpRequest.newBuilder(URI.create(baseEndpoint + "/leaderboard"))
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
        System.out.println("this.leaderboard wil be null");
      }
    } catch (Exception e) {
      e.printStackTrace();

    }
    return null;
  }

  /**
   * Sends a Scoreboard object to update the remote leaderboard.
   *
   * @param scoreboard the Scoreboard object to be sent to the remote server
   * @return true if the scoreboard was successfully sent, false otherwise
   */
  public boolean sendScoreboard(Scoreboard scoreboard) {
    Scoreboard payloadScoreboard = new Scoreboard(scoreboard.getScorelist());
    try {
      HttpClient client = HttpClient.newHttpClient();
      String scoreboardJson = new ObjectMapper().writeValueAsString(payloadScoreboard);

      HttpRequest request = HttpRequest.newBuilder(URI.create(baseEndpoint + "/addScoreboard"))
          .header("Content-Type", "application/json")
          .POST(HttpRequest.BodyPublishers.ofString(scoreboardJson))
          .build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        System.out.println("sent success, remoteLeaderboardAccess");
        return true; // Scoreboard sent successfully
      } else {
        // Handle error status codes if needed
        System.out.println("Error: " + response.statusCode());
      }
    } catch (JsonProcessingException e) {
      System.out.println("Json Failed");
      e.printStackTrace();
      // Handle exceptions if necessary
    } catch (IOException | InterruptedException e) {
      System.out.println("Io/inter failed");
      e.printStackTrace();
    }

    return false; // Scoreboard sending failed
  }
}