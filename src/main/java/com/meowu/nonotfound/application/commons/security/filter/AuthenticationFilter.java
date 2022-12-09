package com.meowu.nonotfound.application.commons.security.filter;

import com.meowu.nonotfound.application.commons.security.stereotype.annotation.Filter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Filter
public class AuthenticationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException{


        chain.doFilter(request, response);
    }
}
