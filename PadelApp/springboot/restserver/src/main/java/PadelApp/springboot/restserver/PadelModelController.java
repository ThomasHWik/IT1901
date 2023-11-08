package PadelApp.springboot.restserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import PadelApp.core.Leaderboard;
import PadelApp.core.Player;
import PadelApp.core.Scoreboard;
import PadelApp.json.FileManagerJson;

@RestController
@RequestMapping("/api/padel")
public class PadelModelController {
    private final PadelModelService padelModelService;

    /**
     * Constructor for PadelModelController class.
     * 
     * @param padelAppService an instance of PadelModelService to be injected via Autowired annotation.
     */
    @Autowired
    public PadelModelController(PadelModelService padelAppService) {
        this.padelModelService = padelAppService;
    }

    /**
     * Endpoint for retrival of leaderboard from the PadelModelService and returns it as a ResponseEntity.
     * @return ResponseEntity<Leaderboard> containing the leaderboard if it exists, or HttpStatus.NOT_FOUND if it doesn't.
     */
    @GetMapping("/leaderboard")
    public ResponseEntity<Leaderboard> getLeaderboard() {
        Leaderboard leaderboard = padelModelService.getLeaderboard();
        if (leaderboard != null) {
            return new ResponseEntity<>(leaderboard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint for receiving a scoreboard object in json format and adding it to the leaderboard.
     * 
     * @param scoreboard the scoreboard object to be added to the leaderboard
     * @return a ResponseEntity object with a success message and HTTP status code 200 if the scoreboard was processed successfully, 
     *         or an error message and HTTP status code 500 if an error occurred while processing the scoreboard
     */
    @PostMapping("/addScoreboard")
    public ResponseEntity<String> receiveScoreboard(@RequestBody Scoreboard scoreboard) {
        try {
            padelModelService.addToLeaderboard(scoreboard);
            System.out.println("processed scoreboard");
            return new ResponseEntity<>("Scoreboard received and processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error receiving and processing scoreboard", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 
    @GetMapping("/test")
    public ResponseEntity<String> testServer(){
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addPlayer(new Player("Thomas",19,2,99999999));
        leaderboard.addPlayer(new Player("Kacper", 20, 3, 44444444));

        ObjectMapper om = new ObjectMapper();

        try {
            return new ResponseEntity<>(om.writeValueAsString(leaderboard), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed json serialization", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */

    /**
     * Endpoint for initializing the PadelModelService.
     * 
     * @return a ResponseEntity object with a success message and HTTP status code 200 if the PadelModelService was initialized successfully, 
     *         or an error message and HTTP status code 500 if an error occurred while initializing the PadelModelService
     */
    @GetMapping("/initialize")
    public ResponseEntity<String> initialize() {
        padelModelService.initialize();
        return new ResponseEntity<>("Tried initializing", HttpStatus.OK);
    }
}
