package main_d.application.service;

import lombok.RequiredArgsConstructor;
import main_d.application.dto.CommandListDTO;
import main_d.application.port.in.GetAccountsBalanceUseCase;
import main_d.application.port.out.LoadAccountList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class GetAccountsBalanceService implements GetAccountsBalanceUseCase {

    private final LoadAccountList loadAccountList;
    @Override
    public String getAccountsBalanceUseCase(CommandListDTO data) {
        return loadAccountList.loadAccountList().getAccountsBalanceAbove(data.getAmount()).toString();
    }
}
