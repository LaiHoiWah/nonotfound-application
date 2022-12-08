package com.meowu.nonotfound.application.core.account.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TokenType{

    @SerializedName("0")
    WEB(0),

    @SerializedName("1")
    APP(1),

    ;

    private int id;

    public static TokenType getById(Integer id){
        if(id == null){
            return WEB;
        }

        for(TokenType type : TokenType.values()){
            if(type.getId() == id){
                return type;
            }
        }

        return WEB;
    }
}
