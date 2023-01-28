package main_d.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import main_d.application.dto.CommandMovieDTO;
import main_d.application.port.in.LoadMovieUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
