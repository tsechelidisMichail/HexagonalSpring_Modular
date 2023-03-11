package domain_imp;

import domain.Movie;
import lombok.Getter;

@Getter
public class MovieImp implements Movie {

    public MovieImp(String name) {
        this.name = name;
    }

    private String name;

}
