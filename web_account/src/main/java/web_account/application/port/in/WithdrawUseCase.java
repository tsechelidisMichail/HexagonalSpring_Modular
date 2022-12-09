package web_account.application.port.in;

import web_account.application.dto.CommandBalanceDTO;

public interface WithdrawUseCase {
    String withdraw(CommandBalanceDTO commandBalanceDTO);
}
