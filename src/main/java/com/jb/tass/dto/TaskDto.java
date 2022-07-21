package com.jb.tass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

//Created by sniryosefof on 29 יוני
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskDto {

    private int id;
    @NotBlank
    private String caption;
    @NotBlank
    private String info;
    @NotBlank
    private String classification;
    @NotBlank
    private LocalDateTime dueDate;

    public TaskDto(TaskPayLoadDto payloadDto){
        this.caption = payloadDto.getCaption();
        this.classification = payloadDto.getClassification();
        this.dueDate = payloadDto.getDueDate();
        this.info = payloadDto.getInfo();
    }
}
