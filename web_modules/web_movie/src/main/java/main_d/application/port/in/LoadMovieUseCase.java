package main_d.application.port.in;

import main_d.application.dto.CommandMovieDTO;
public interface LoadMovieUseCase {
    String loadMovie(CommandMovieDTO commandMovieDTO);
}
