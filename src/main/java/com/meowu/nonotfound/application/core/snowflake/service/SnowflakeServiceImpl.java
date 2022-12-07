package com.meowu.nonotfound.application.core.snowflake.service;

import com.meowu.commons.utils.AssertUtils;
import com.meowu.commons.utils.IPUtils;
import com.meowu.nonotfound.application.core.snowflake.manager.SnowflakeManager;
import com.meowu.support.client.core.snowflake.entity.response.SnowflakeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class SnowflakeServiceImpl implements SnowflakeService{

    @Autowired
    private Environment environment;

    @Autowired
    private SnowflakeManager snowflakeManager;

    @Override
    public SnowflakeVo create(){
        // environment properties
        String  applicationName = environment.getProperty("spring.application.name");
        Integer port            = environment.getProperty("server.port", Integer.class);

        // machine properties
        List<String> ips = IPUtils.findByUsing();

        // verify params
        AssertUtils.hasText(applicationName, "application name must not be null");
        AssertUtils.notNull(port, "server port must not be null");
        AssertUtils.isNotEmpty(ips, "machine ip list must not be null");

        // create snowflake
        return snowflakeManager.create(applicationName, ips.get(0), port, System.currentTimeMillis());
    }
}
