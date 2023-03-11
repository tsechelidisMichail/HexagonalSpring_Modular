package domain;

public interface Account {

	boolean deposit(int data);

	boolean withdraw(int data);

	Integer getBalance();

	Integer getId();

}
