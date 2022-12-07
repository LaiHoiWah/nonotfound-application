package com.meowu.nonotfound.application.core.account.manager.client;

import com.meowu.account.client.entity.request.AccountDto;
import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.commons.security.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${nacos.server.account}")
public interface AccountClient{

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> register(@RequestBody AccountDto account);

    @PostMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Response<AccountVo> getByUsernameAndPassword(@RequestBody AccountDto accountDto);
}
