package com.meowu.nonotfound.application.commons.security.stereotype.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Filter{

    @AliasFor(annotation = Component.class)
    String value() default "";
}