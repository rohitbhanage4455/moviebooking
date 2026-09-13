package MovieBooking.service;

import MovieBooking.entity.Movie;
import MovieBooking.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie updateMovie(Long id, Movie movie) {

        Movie existingMovie = getMovieById(id);

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setGenre(movie.getGenre());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Long id) {

        Movie movie = getMovieById(id);

        movieRepository.delete(movie);
    }
}