package com.meowu.nonotfound.application.core.account.api.webservice;

import com.meowu.account.client.entity.request.AccountDto;
import com.meowu.commons.security.response.Response;
import com.meowu.nonotfound.application.commons.security.stereotype.entity.response.TokenVo;
import com.meowu.nonotfound.application.core.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/1.0/account")
@RestController
public class AccountRestController{

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/login/web", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<TokenVo> loginWeb(AccountDto accountDto){
        TokenVo token = accountService.loginWebsite(accountDto);

        return new Response<TokenVo>("", token);
    }
}
