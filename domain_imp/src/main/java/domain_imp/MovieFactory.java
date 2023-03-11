package domain_imp;

import domain.AbstractMovieFactory;
import domain.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieFactory implements AbstractMovieFactory {
    @Override
    public Movie createMovie(String name) {
        return new MovieImp(name);
    }
}
