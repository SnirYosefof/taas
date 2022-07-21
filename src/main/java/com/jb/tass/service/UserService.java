package com.jb.tass.service;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.exception.TaskSystemException;

import java.util.List;

//Created by sniryosefof on 30 יוני
public interface UserService {

    List<TaskDto> getAllTasks(int userId);

    void addTask(int userId, TaskDto taskDto) throws TaskSystemException;

    TaskDto updateTask(int taskId, TaskDto taskDto) throws TaskSystemException;

    void deleteTask(int taskId) throws TaskSystemException;

    int countById();

}
