package main_d.adapter.out.persistence.primary;

import lombok.RequiredArgsConstructor;
import main_d.Account;
import main_d.AccountList;
import main_d.application.port.out.queries.LoadAccountList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class AccountListAdapter implements LoadAccountList {

    private final AccountJpaRepository accountJpaRepository;

    @Autowired
    private final AccountList accountList;

    @Autowired
    private final Account accountDomain;

    //Of course this is bad - this is testing dependencies
    //Collections of data shall be processed - if can - with queries in the database
    //Lets assume we need to filter balances above a threshold, and we need to write java code for that.
    @Override
    public AccountList loadAccountList() {
        AccountList newList = accountList.newAccountList();
        newList.populate(
                (ArrayList<Account>) accountJpaRepository.findAll().stream().map(
                        accountJpaEntity -> accountDomain.newAccount(accountJpaEntity.getId(), accountJpaEntity.getBalance())
                ).collect(Collectors.toList()));
        return newList;
    }
}
