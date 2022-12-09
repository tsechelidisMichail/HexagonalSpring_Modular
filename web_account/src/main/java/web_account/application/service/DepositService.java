package web_account.application.service;

import domain.Account;
import web_account.application.dto.CommandBalanceDTO;
import web_account.application.port.in.DepositUseCase;
import web_account.application.port.out.LoadAccount;
import web_account.application.port.out.UpdateAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
class DepositService implements DepositUseCase{
	private final LoadAccount loadAccount;
	private final UpdateAccount updateAccount;

	@Override
	public String deposit(CommandBalanceDTO data) {
		int money = data.getBalance();
		int id = data.getId();
		
		Account account = loadAccount.loadAccount(id);

		if (account.deposit(money)) {
			updateAccount.updateAccount(account);
			int balanceResult = account.getBalance();
			return "Success! " + balanceResult;
		}
		return "failed";
	}

}
