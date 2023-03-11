package web.application.port.in;

import web.application.dto.CommandMovieDTO;

public interface LoadMovieUseCase {
    String loadMovie(CommandMovieDTO commandMovieDTO);
}
