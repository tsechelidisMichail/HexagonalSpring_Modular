package domain;

public interface AbstractAccountFactory {
    Account createAccount(int id, int balance);
}
