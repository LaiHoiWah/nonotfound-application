package com.meowu.nonotfound.application.core.account.entity;

import com.meowu.commons.doamin.Creatable;
import com.meowu.commons.doamin.Entity;
import com.meowu.commons.doamin.Updatable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Token extends Entity<String> implements Creatable, Updatable{

    private String    accountId;
    private Long      expire;
    private TokenType type;
    private Boolean   alive;
    private Date      effectTime;
    private Date      createTime;
    private Date      updateTime;
}
