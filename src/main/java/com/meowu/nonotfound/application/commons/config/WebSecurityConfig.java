package com.meowu.nonotfound.application.commons.config;

import com.meowu.nonotfound.application.commons.security.filter.AuthenticationFilter;
import com.meowu.nonotfound.application.commons.security.handler.AccessDeniedHandler;
import com.meowu.nonotfound.application.commons.security.handler.AuthenticationEntryPointHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthenticationEntryPointHandler authenticationEntryPointHandler;

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
            // session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            // authentication handler
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                                .authenticationEntryPoint(authenticationEntryPointHandler)
            // authentication filter
            .and()
            .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
            // url list
            .authorizeRequests().antMatchers("/api/1.0/account/login/web").permitAll()
                                .antMatchers(HttpMethod.OPTIONS).permitAll()
            .anyRequest().authenticated();
    }
}
