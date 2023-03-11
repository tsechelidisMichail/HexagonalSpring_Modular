package web.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import web.application.dto.CommandBalanceDTO;
import web.application.port.in.DepositUseCase;

@RestController
@RequiredArgsConstructor
class DepositController {
	private final DepositUseCase depositUseCase;

	@PostMapping(path = "/account/deposit/{id}/{amount}")
	String deposit(@PathVariable int id, @PathVariable int amount) {
		CommandBalanceDTO data = new CommandBalanceDTO(id, amount);
		return depositUseCase.deposit(data);
	}
}
