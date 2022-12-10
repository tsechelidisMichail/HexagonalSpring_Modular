package main_d.application.service;

import lombok.RequiredArgsConstructor;
import main_d.Account;
import main_d.application.dto.CommandBalanceDTO;
import main_d.application.port.in.DepositUseCase;
import main_d.application.port.out.LoadAccount;
import main_d.application.port.out.UpdateAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
class DepositService implements DepositUseCase {
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
