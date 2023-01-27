package main_d.application.port.in;

import main_d.application.dto.CommandBalanceDTO;

public interface WithdrawUseCase {
    String withdraw(CommandBalanceDTO commandBalanceDTO);
}
