package PadelApp.springboot.restserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import PadelApp.core.Leaderboard;
import PadelApp.core.Scoreboard;

@RestController
@RequestMapping(PadelModelController.PADEL_MODEL_SERVICE_PATH)
public class PadelModelController {

    public static final String PADEL_MODEL_SERVICE_PATH = "padel";
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
}
