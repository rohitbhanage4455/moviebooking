package MovieBooking.service;

import MovieBooking.entity.Show;
import MovieBooking.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
    }

    public Show updateShow(Long id, Show show) {

        Show existingShow = getShowById(id);

        existingShow.setMovie(show.getMovie());
        existingShow.setShowTime(show.getShowTime());
        existingShow.setTotalSeats(show.getTotalSeats());
        existingShow.setAvailableSeats(show.getAvailableSeats());

        return showRepository.save(existingShow);
    }

    public void deleteShow(Long id) {

        Show show = getShowById(id);

        showRepository.delete(show);
    }
}