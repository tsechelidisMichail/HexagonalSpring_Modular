package main_d.application.service;

import lombok.RequiredArgsConstructor;
import main_d.Account;
import main_d.application.dto.CommandBalanceDTO;
import main_d.application.port.in.WithdrawUseCase;
import main_d.application.port.out.LoadAccount;
import main_d.application.port.out.UpdateAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
class WithdrawService implements WithdrawUseCase {
    private final LoadAccount loadAccount;
    private final UpdateAccount updateAccount;

    @Override
    public String withdraw(CommandBalanceDTO data) {
        int money = data.getBalance();
        int id = data.getId();

        Account account = loadAccount.loadAccount(id);

        if (account.withdraw(money)) {
            updateAccount.updateAccount(account);
            int balanceResult = account.getBalance();
            return "Success! " + balanceResult;
        }
        return "failed";
    }

}
