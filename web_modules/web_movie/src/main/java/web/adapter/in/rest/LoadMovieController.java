package web.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import web.application.dto.CommandMovieDTO;
import web.application.port.in.LoadMovieUseCase;

@RestController
@RequiredArgsConstructor
class LoadMovieController {

    private final LoadMovieUseCase loadMovieController;

    @PostMapping(path = "/movie/loadMovie/{id}/{movieName}")
    String loadMovie(@PathVariable int id, @PathVariable String movieName) {
        CommandMovieDTO data = new CommandMovieDTO(id, movieName);
        return loadMovieController.loadMovie(data);
    }
}
