package com.jb.tass.security;

import com.jb.tass.bean.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Created by sniryosefof on 30 יוני
public class Information {
    private int userId;
    private ClientType type;
    private LocalDateTime time;
    private String email;
}
