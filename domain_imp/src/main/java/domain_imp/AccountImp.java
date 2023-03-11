package domain_imp;

import domain.Account;
import lombok.Getter;

@Getter
public class AccountImp implements Account {

	private Integer id;

	private Integer balance;

	public AccountImp( Integer id, Integer balance) {
		this.id = id;
		this.balance = balance;
	}

	public boolean deposit(int data) {
		if(data>0) {
			balance += data;
			return true;
		}
		return false;
	}
	
	public boolean withdraw(int data) {
		if(data>=0 && data<=balance) {
			balance -= data;
			return true;
		}
		return false;
	}

}
