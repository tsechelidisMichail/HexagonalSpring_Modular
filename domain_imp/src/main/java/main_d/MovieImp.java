package main_d;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MovieImp implements Movie{

    private String name;

    @Override
    public Movie newMovie(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }
}
