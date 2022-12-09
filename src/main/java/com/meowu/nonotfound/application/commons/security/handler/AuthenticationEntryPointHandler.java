package com.meowu.nonotfound.application.commons.security.handler;

import com.meowu.commons.security.response.Response;
import com.meowu.commons.utils.GsonUtils;
import com.meowu.nonotfound.application.commons.security.ResponseCode;
import com.meowu.nonotfound.application.commons.security.stereotype.annotation.Handler;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Handler
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint{

    private String charset = "UTF-8";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException{
        response.setCharacterEncoding(charset);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().println(GsonUtils.toJson(new Response().failure(ResponseCode.UNAUTHORIZED, "Invalid token, please try login again.")));
        response.getWriter().flush();
    }
}
