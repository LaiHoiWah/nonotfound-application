package com.meowu.nonotfound.application.commons.security.stereotype.entity.response;

import com.meowu.account.client.entity.response.AccountVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TokenVo{

    private String    token;
    private AccountVo account;
    private Integer   type;
    private Boolean   alive;
    private Long      expire;
    private Date      effectTime;
    private Date      createTime;
}
