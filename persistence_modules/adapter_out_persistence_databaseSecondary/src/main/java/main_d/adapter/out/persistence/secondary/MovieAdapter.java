package main_d.adapter.out.persistence.secondary;

import lombok.RequiredArgsConstructor;
import main_d.Movie;
import main_d.application.port.out.queries.LoadMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class MovieAdapter implements LoadMovie {

	private final MovieJpaRepository movieJpaRepository;

	//A common reference must be saved for optimistic lock(@version ) to work on .save()
	private MovieJpaEntity movie;

	@Autowired
	private Movie movieDomain;

	@Override
	public Movie loadMovie(String name) {
		movie = movieJpaRepository.findMovieByName(name);
		return movieDomain.newMovie(movie.getName());
	}
	
}
