package main_d;

public interface Account {

	boolean deposit(int data);

	boolean withdraw(int data);

	Account update(int id,int balance);

	Account newAccount(int id, int balance);

	Integer getBalance();

	Integer getId();

}
