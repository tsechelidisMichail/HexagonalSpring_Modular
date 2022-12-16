package main_d;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class AccountListImp implements AccountList{
    private final ArrayList<Account> accounts = new ArrayList<>();
    @Override
    public ArrayList<Account> getAccountsBalanceAbove(Integer amount) {
        return new ArrayList<>(accounts.stream().filter(account -> account.getBalance() >= amount).collect(Collectors.toList()));
    }

    @Override
    public void add(Account account) {
        accounts.add(account);
    }

    @Override
    public void populate(ArrayList<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    @Override
    public AccountList newAccountList() {
        return new AccountListImp();
    }
}
