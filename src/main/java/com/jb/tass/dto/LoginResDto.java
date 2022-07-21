package com.jb.tass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Created by sniryosefof on 30 יוני
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResDto {

    private UUID token;
    private String email;

}
