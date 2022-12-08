package com.meowu.nonotfound.application.core.account.manager;

import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.commons.utils.*;
import com.meowu.nonotfound.application.commons.security.stereotype.annotation.Manager;
import com.meowu.nonotfound.application.commons.security.stereotype.consts.TokenConstants;
import com.meowu.nonotfound.application.core.account.entity.Token;
import com.meowu.nonotfound.application.core.account.entity.TokenType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Manager
public class TokenManager{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SnowflakeUtils snowflakeUtils;

    public Token generateWebToken(AccountVo account){
        AssertUtils.notNull(account, "account must not be null");
        AssertUtils.hasText(account.getId(), "account id must not be null");

        // attributes
        String accountId = account.getId();
        Date   now       = new Date();

        // create token
        Token token = new Token();
        token.setId(RadixUtils.toString(snowflakeUtils.nextId(), 62));
        token.setAccountId(accountId);
        token.setType(TokenType.WEB);
        token.setAlive(true);
        token.setExpire(TokenConstants.WEB_TOKEN_EXPIRE);
        token.setCreateTime(now);
        token.setEffectTime(DateTimeUtils.plusSeconds(token.getCreateTime(), token.getExpire().intValue()));

        // cache
        String cacheName = TokenConstants.WEB_TOKEN_CACHE_NAME + token.getId();
        String jsonValue = GsonUtils.toJson(token);
        redisTemplate.opsForValue().set(cacheName, jsonValue, token.getExpire(), TimeUnit.SECONDS);

        return token;
    }

    public Token generateAppToken(AccountVo account){
        AssertUtils.notNull(account, "account must not be null");

        Token token = new Token();
        token.setAccountId(account.getId());

        return token;
    }

    public Token getWebToken(String id){
        AssertUtils.hasText(id, "token id must not be null");

        // key name
        String cacheName = TokenConstants.WEB_TOKEN_CACHE_NAME + id;
        // get value
        String jsonValue = redisTemplate.opsForValue().get(cacheName);

        // return
        return StringUtils.isBlank(jsonValue) ? null : GsonUtils.fromJson(jsonValue, Token.class);
    }
}
