package web.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import web.application.dto.CommandBalanceDTO;
import web.application.port.in.WithdrawUseCase;

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
