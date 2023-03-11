package web.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
@Getter
@NoArgsConstructor
public class CommandMovieDTO {

    /*
        Must reflect the Controller pathing, due to @RequiredArgs - from top to bottom id->balance.
     */
    @NotNull
    private Integer id;

    @NotNull
    private String movieName;

}
