package main_d.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

@RequiredArgsConstructor
@Getter
@NoArgsConstructor
public class CommandListDTO {

    @NonNull
    private Integer amount;
}
