package com.meowu.nonotfound.application.core.account.entity.converter;

import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.nonotfound.application.commons.security.stereotype.entity.response.TokenVo;
import com.meowu.nonotfound.application.core.account.entity.Token;
import org.apache.commons.lang3.StringUtils;

public class TokenConverter{

    private TokenConverter(){
        throw new IllegalStateException("Not allow to initialize by constructor");
    }

    public static TokenVo convert(Token token, AccountVo account){
        if(token == null){
            return null;
        }

        // create view
        TokenVo view = new TokenVo();

        // token attributes
        if(StringUtils.isNotBlank(token.getId())){
            view.setToken(token.getId());
        }
        if(token.getAlive() != null){
            view.setAlive(token.getAlive());
        }
        if(token.getExpire() != null){
            view.setExpire(token.getExpire());
        }
        if(token.getEffectTime() != null){
            view.setEffectTime(token.getEffectTime());
        }
        if(token.getCreateTime() != null){
            view.setCreateTime(token.getCreateTime());
        }

        // account attributes
        if(account != null){
            view.setAccount(account);
        }

        return view;
    }
}
