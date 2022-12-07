package com.meowu.nonotfound.application.core.account.service;

import com.meowu.account.client.entity.request.AccountDto;
import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.nonotfound.application.core.account.manager.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountManager accountManager;

    @Transactional
    @Override
    public AccountVo login(AccountDto accountDto){
        // verify
        AccountVo account = accountManager.verify(accountDto.getUsername(), accountDto.getPassword());

        // TODO create token

        return account;
    }
}
