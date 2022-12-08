package com.meowu.nonotfound.application.core.account.service;

import com.meowu.account.client.entity.request.AccountDto;
import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.nonotfound.application.commons.security.stereotype.entity.response.TokenVo;

public interface AccountService{

    TokenVo loginWebsite(AccountDto accountDto);

    TokenVo loginApp(AccountDto accountDto);
}
