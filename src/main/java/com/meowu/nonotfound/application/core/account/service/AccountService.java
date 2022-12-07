package com.meowu.nonotfound.application.core.account.service;

import com.meowu.account.client.entity.request.AccountDto;
import com.meowu.account.client.entity.response.AccountVo;

public interface AccountService{

    AccountVo login(AccountDto accountDto);
}
