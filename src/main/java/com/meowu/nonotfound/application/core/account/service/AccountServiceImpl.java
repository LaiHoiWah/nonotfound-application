package com.meowu.nonotfound.application.core.account.service;

import com.meowu.account.client.entity.request.AccountDto;
import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.nonotfound.application.commons.security.stereotype.entity.response.TokenVo;
import com.meowu.nonotfound.application.core.account.entity.Token;
import com.meowu.nonotfound.application.core.account.entity.converter.TokenConverter;
import com.meowu.nonotfound.application.core.account.manager.AccountManager;
import com.meowu.nonotfound.application.core.account.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountManager accountManager;

    @Autowired
    private TokenManager tokenManager;

    @Transactional
    @Override
    public TokenVo loginWebsite(AccountDto accountDto){
        // verify
        AccountVo account = accountManager.verify(accountDto.getUsername(), accountDto.getPassword());

        // create token
        Token token = tokenManager.generateWebToken(account);

        // return
        return TokenConverter.convert(token, account);
    }

    @Transactional
    @Override
    public TokenVo loginApp(AccountDto accountDto){
        // verify
        AccountVo account = accountManager.verify(accountDto.getUsername(), accountDto.getPassword());

        // create token
        Token token = tokenManager.generateAppToken(account);

        // return
        return TokenConverter.convert(token, account);
    }
}
