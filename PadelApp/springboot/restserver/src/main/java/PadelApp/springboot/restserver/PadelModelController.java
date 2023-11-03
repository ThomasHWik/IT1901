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

    @Autowired
    public PadelModelController(PadelModelService padelAppService) {
        this.padelModelService = padelAppService;
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<Leaderboard> getLeaderboard() {
        Leaderboard leaderboard = padelModelService.getLeaderboard("Leaderboard");
        if (leaderboard != null) {
            return new ResponseEntity<>(leaderboard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addScoreboard")
    public ResponseEntity<String> receiveScoreboard(@RequestBody Scoreboard scoreboard) {
        try {
            padelModelService.addToLeaderboard(scoreboard);
            return new ResponseEntity<>("Scoreboard received and processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error receiving and processing scoreboard", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> testServer(){
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addPlayer(new Player("Thomas",19,2,99999999));

        ObjectMapper om = new ObjectMapper();

        try {
            return new ResponseEntity<>(om.writeValueAsString(leaderboard), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed json serialization", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
    }
}
