package main_d.application.port.in;

import main_d.application.dto.CommandBalanceDTO;

public interface DepositUseCase {
	String deposit(CommandBalanceDTO commandBalanceDTO);
}
