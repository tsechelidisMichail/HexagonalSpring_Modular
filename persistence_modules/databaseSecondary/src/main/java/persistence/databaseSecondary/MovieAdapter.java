package persistence.databaseSecondary;

import domain.AbstractMovieFactory;
import domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queries.LoadMovie;

@RequiredArgsConstructor
@Component
class MovieAdapter implements LoadMovie {

	private final MovieJpaRepository movieJpaRepository;
	private final AbstractMovieFactory movieFactory;

	@Override
	public Movie loadMovie(String name) {
		MovieJpaEntity movie =  movieJpaRepository.findMovieByName(name);
		return movieFactory.createMovie(movie.getName());
	}
	
}
