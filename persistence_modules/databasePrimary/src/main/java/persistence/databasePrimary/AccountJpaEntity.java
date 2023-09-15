package persistence.databasePrimary;

import domain.Account;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "account")
@Data
class AccountJpaEntity {

	@Version
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
