package com.meowu.nonotfound.application.commons.security.stereotype.consts;

import java.util.concurrent.TimeUnit;

public interface TokenConstants{

    String WEB_TOKEN_CACHE_NAME = "token:web:";

    // 2 hours
    long WEB_TOKEN_EXPIRE = TimeUnit.HOURS.toSeconds(2);

    // 30 days
    long APP_TOKEN_EXPIRE = TimeUnit.DAYS.toSeconds(30);
}
