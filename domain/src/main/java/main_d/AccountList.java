package main_d;

import java.util.ArrayList;

public interface AccountList {

    ArrayList<Account> getAccountsBalanceAbove(Integer amount);
    void add(Account account);

    void populate(ArrayList<Account> accounts);

    AccountList newAccountList();
}
