package main_d.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import main_d.application.dto.CommandBalanceDTO;
import main_d.application.port.in.WithdrawUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class WithdrawController {
    private final WithdrawUseCase withdrawUseCase;

    @PostMapping(path = "/account/withdraw/{id}/{amount}")
    String withdraw(@PathVariable int id, @PathVariable int amount) {
        CommandBalanceDTO data = new CommandBalanceDTO(id, amount);
        return withdrawUseCase.withdraw(data);
    }
}
