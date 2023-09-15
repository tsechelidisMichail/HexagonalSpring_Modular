package persistence.databasePrimary;

import domain.AbstractAccountFactory;
import domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queries.LoadAccount;
import queries.UpdateAccount;

@RequiredArgsConstructor
@Component
class AccountAdapter implements LoadAccount, UpdateAccount {

	private final AccountJpaRepository accountJpaRepository;

	private final AbstractAccountFactory accountFactory;

	@Override
	public Account loadAccount(int id) {
		AccountJpaEntity account = accountJpaRepository.findById(id).orElseThrow();
		return accountFactory.createAccount(account.getId(), account.getBalance());
	}

	@Override
	public void updateAccount(Account accountUpdated) {
		AccountJpaEntity account = accountJpaRepository.findById(accountUpdated.getId()).orElseThrow();
		accountJpaRepository.save(account.update(accountUpdated));
	}

	
}
