package com.meowu.nonotfound.application.commons.utils;

import com.meowu.commons.security.response.Response;
import com.meowu.commons.utils.GsonUtils;
import com.meowu.nonotfound.application.commons.security.ResponseCode;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResponseUtils{

    public static void writeAuthenticationExceptionBody(HttpServletResponse response) throws IOException{
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().println(GsonUtils.toJson(new Response().failure(ResponseCode.UNAUTHORIZED, "Invalid token.")));
        response.getWriter().flush();
    }
}
