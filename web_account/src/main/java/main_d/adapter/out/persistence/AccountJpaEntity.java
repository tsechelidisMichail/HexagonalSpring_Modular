package main_d.adapter.out.persistence;

import lombok.Data;
import main_d.Account;

import javax.persistence.*;


@Entity
@Table(name = "account")
@Data
class AccountJpaEntity {

	@Version
	@GeneratedValue
	private Integer version;

	@Id
	@GeneratedValue
	private int id;

	@Column
	private int balance;

	public AccountJpaEntity update(Account accountUpdated) {
		this.balance = accountUpdated.getBalance();
		this.id = accountUpdated.getId();
		return this;
	}
}
