package com.jb.tass.exception;

import lombok.Getter;

//Created by sniryosefof on 29 יוני
@Getter
public enum ErrMsg {

    ID_NOT_EXIST("id not exist"),
    INVALID_DATES("star date must be before end date"),
    ID_ALREADY_EXIST("id already exist");



    private  String msg;
    private ErrMsg (String msg){
        this.msg=msg;
    }
}
