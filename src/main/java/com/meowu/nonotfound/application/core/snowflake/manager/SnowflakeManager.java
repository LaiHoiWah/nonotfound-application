package com.meowu.nonotfound.application.core.snowflake.manager;

import com.meowu.commons.security.response.Response;
import com.meowu.commons.utils.AssertUtils;
import com.meowu.nonotfound.application.commons.security.ResponseCode;
import com.meowu.nonotfound.application.commons.security.exception.RemoteApiException;
import com.meowu.nonotfound.application.commons.security.stereotype.annotation.Manager;
import com.meowu.nonotfound.application.core.snowflake.manager.client.SnowflakeClient;
import com.meowu.support.client.core.snowflake.entity.request.SnowflakeDto;
import com.meowu.support.client.core.snowflake.entity.response.SnowflakeVo;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class SnowflakeManager{

    @Autowired
    private SnowflakeClient snowflakeClient;

    public SnowflakeVo create(String applicationName, String ip, Integer port, Long timeGen){
        AssertUtils.hasText(applicationName, "application name must not be null");
        AssertUtils.hasText(ip, "server ip must not be null");
        AssertUtils.notNull(port, "server port must not be null");
        AssertUtils.notNull(timeGen, "server time gen must not be null");

        // request body
        SnowflakeDto snowflakeDto = new SnowflakeDto();
        snowflakeDto.setApplicationName(applicationName);
        snowflakeDto.setIp(ip);
        snowflakeDto.setPort(port);
        snowflakeDto.setTimeGen(timeGen);

        // call api
        Response<SnowflakeVo> response = snowflakeClient.create(snowflakeDto);
        // verify response
        if(!response.getSuccess() && response.getCode() != ResponseCode.SUCCESS){
            throw new RemoteApiException(response.getMsg());
        }

        return response.getData();
    }
}
