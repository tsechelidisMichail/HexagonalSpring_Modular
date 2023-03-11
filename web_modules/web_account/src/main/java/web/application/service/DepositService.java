package web.application.service;

import domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import queries.LoadAccount;
import queries.UpdateAccount;
import web.application.dto.CommandBalanceDTO;
import web.application.port.in.DepositUseCase;

@RequiredArgsConstructor
@Transactional("primaryTransactionManager")
@EnableTransactionManagement
@Service
class DepositService implements DepositUseCase {
	private final LoadAccount loadAccount;
	private final UpdateAccount updateAccount;
	/*TODO:Understand transactional and the scoping of the management.
	 * Where does the concurrency is being handled. This is for every service.
	 */
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
