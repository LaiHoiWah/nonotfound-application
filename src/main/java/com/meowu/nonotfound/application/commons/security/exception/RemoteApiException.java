package com.meowu.nonotfound.application.commons.security.exception;

import com.meowu.commons.security.exception.MeowuException;

import java.text.MessageFormat;

public class RemoteApiException extends MeowuException{

    public RemoteApiException(){
        super();
    }

    public RemoteApiException(String message){
        super(message);
    }

    public RemoteApiException(Throwable cause){
        super(cause);
    }

    public RemoteApiException(String message, Throwable cause){
        super(message, cause);
    }

    public RemoteApiException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public RemoteApiException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
