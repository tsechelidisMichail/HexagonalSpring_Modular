package main_d.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import main_d.application.dto.CommandBalanceDTO;
import main_d.application.port.in.DepositUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
