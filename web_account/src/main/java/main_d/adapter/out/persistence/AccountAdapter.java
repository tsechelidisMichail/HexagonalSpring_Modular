package main_d.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import main_d.Account;
import main_d.application.port.out.LoadAccount;
import main_d.application.port.out.UpdateAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
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
