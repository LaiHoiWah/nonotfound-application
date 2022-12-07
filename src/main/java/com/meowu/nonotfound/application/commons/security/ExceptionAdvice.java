package com.meowu.nonotfound.application.commons.security;

import com.meowu.commons.security.exception.MeowuException;
import com.meowu.commons.security.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice{

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * jdk exception handler
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exception(Exception e){
        LOGGER.error(e.getMessage(), e);

        return new Response().failure("We are sorry to tell you that something goes wrong.");
    }

    /**
     * business exception handler
     */
    @ExceptionHandler(MeowuException.class)
    @ResponseBody
    public Response meowuException(MeowuException e){
        LOGGER.error(e.getMessage(), e);

        return new Response().failure(e.getMessage());
    }
}
