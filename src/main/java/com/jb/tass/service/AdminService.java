package com.jb.tass.service;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.dto.UserDto;

import java.util.List;

//Created by sniryosefof on 30 יוני
public interface AdminService {

    int countUsers();
    int countTasks();
    List<TaskDto> getAllTasks();
    List<UserDto> getAllUsers();
}
