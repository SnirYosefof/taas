package com.jb.tass.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

//Created by sniryosefof on 29 יוני
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateBetweenReqReq {

    private Timestamp start;
    private Timestamp end;
}
