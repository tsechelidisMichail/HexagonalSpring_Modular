package web.application.port.in;

import web.application.dto.CommandBalanceDTO;

public interface DepositUseCase {
	String deposit(CommandBalanceDTO commandBalanceDTO);
}
