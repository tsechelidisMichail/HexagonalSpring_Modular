package web_account.adapter.in.rest;

import web_account.application.dto.CommandBalanceDTO;
import web_account.application.port.in.WithdrawUseCase;
import lombok.RequiredArgsConstructor;
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
