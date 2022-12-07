package com.meowu.nonotfound.application.core.account.manager;

import com.meowu.account.client.entity.request.AccountDto;
import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.commons.security.response.Response;
import com.meowu.commons.utils.AssertUtils;
import com.meowu.nonotfound.application.commons.security.ResponseCode;
import com.meowu.nonotfound.application.commons.security.exception.RemoteApiException;
import com.meowu.nonotfound.application.commons.security.stereotype.annotation.Manager;
import com.meowu.nonotfound.application.core.account.dao.AccountDao;
import com.meowu.nonotfound.application.core.account.manager.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class AccountManager{

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private AccountDao accountDao;

    public AccountVo verify(String username, String password){
        AssertUtils.hasText(username, "username must not be null");
        AssertUtils.hasText(password, "password must not be null");

        // call api
        Response<AccountVo> response = accountClient.register(new AccountDto(username, password));
        // verify response
        if(!response.getSuccess() && response.getCode() != ResponseCode.SUCCESS){
            throw new RemoteApiException(response.getMsg());
        }

        // get account
        AccountVo account = response.getData();
        if(account == null){
            throw new RemoteApiException("response data is null");
        }

        // update record
        accountDao.saveOrUpdate(account);

        // return
        return account;
    }
}
