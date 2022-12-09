package web_account.adapter.out.persistense;

import domain.Account;
import web_account.application.port.out.LoadAccount;
import web_account.application.port.out.UpdateAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Repository
class AccountAdapter implements LoadAccount, UpdateAccount{
	private final AccountJpaRepository accountJpaRepository;

	//A common reference must be saved for optimistic lock(@version ) to work on .save()
	private AccountJpaEntity account;

	@Autowired
	private Account accountDomain;
	
	@Override
	public Account loadAccount(int id) {
		account = accountJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		return accountDomain.update(account.getId(), account.getBalance());
	}

	@Override
	public void updateAccount(Account accountUpdated) {
		accountJpaRepository.save(account.update(accountUpdated));
	}
	
}
