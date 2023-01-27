package main_d;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class AccountImp implements Account {

	private Integer id;

	private Integer balance;

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

	@Override
	public Account update(int id, int balance) {
		this.id = id;
		this.balance = balance;
		return this;
	}

	@Override
	public Account newAccount(int id, int balance) {
		//This is a change

		return new AccountImp().update(id, balance);
	}

	@Override
	public Integer getBalance() {
		return this.balance;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

}
