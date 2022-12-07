package com.meowu.nonotfound.application.commons.config;

import com.meowu.commons.utils.SnowflakeUtils;
import com.meowu.nonotfound.application.core.snowflake.service.SnowflakeService;
import com.meowu.support.client.core.snowflake.entity.response.SnowflakeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeConfig{

    @Autowired
    private SnowflakeService snowflakeService;

    @Bean
    public SnowflakeUtils snowflakeUtils(){
        // create snowflake
        SnowflakeVo snowflake = snowflakeService.create();

        // init util
        return new SnowflakeUtils(snowflake.getCenterId(), snowflake.getWorkerId(), snowflake.getTimeGen());
    }
}
