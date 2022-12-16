package main_d.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import main_d.application.dto.CommandListDTO;
import main_d.application.port.in.GetAccountsBalanceUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class GetAccountsBalanceAboveController {
    private final GetAccountsBalanceUseCase getAccountsBalanceUseCase;

    @PostMapping(path = "/account/getAccountsBalanceAbove/{amount}")
    String getAccountsBalanceAbove(@PathVariable int amount) {
        CommandListDTO data = new CommandListDTO(amount);
        return getAccountsBalanceUseCase.getAccountsBalanceUseCase(data);
    }
}
