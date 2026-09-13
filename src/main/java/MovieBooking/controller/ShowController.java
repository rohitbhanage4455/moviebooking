package MovieBooking.controller;

import MovieBooking.entity.Show;
import MovieBooking.service.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public ResponseEntity<Show> addShow(@RequestBody Show show) {
        return ResponseEntity.ok(showService.addShow(show));
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(
            @PathVariable Long id,
            @RequestBody Show show) {

        return ResponseEntity.ok(showService.updateShow(id, show));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.ok("Show deleted successfully");
    }
}