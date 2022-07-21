package com.jb.tass.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Created by sniryosefof on 30 יוני
public class UserDto {
    @Min(0)
    private int id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @NotBlank
    private String type;

    @Singular
    private List<TaskDto> tasks = new ArrayList<>();
}
