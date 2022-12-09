package web_account.application.service;

import domain.Account;
import org.springframework.transaction.annotation.Transactional;
import web_account.application.dto.CommandBalanceDTO;
import web_account.application.port.in.WithdrawUseCase;
import web_account.application.port.out.LoadAccount;
import web_account.application.port.out.UpdateAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
