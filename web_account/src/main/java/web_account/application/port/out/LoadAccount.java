package web_account.application.port.out;

import domain.Account;

public interface LoadAccount {
	Account loadAccount(int id);
}
