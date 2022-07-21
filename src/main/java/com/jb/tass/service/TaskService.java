package com.jb.tass.service;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.exception.TaskSystemException;

import java.sql.Timestamp;
import java.util.List;

//Created by sniryosefof on 29 יוני
public interface TaskService {
    TaskDto addTask(TaskDto taskDto) throws TaskSystemException;
    TaskDto updateTask(int taskId,TaskDto taskDto) throws TaskSystemException;
    void deleteTask(int taskId) throws TaskSystemException;

    List<TaskDto> getAllTasks();
    TaskDto getOneTask(int taskId) throws TaskSystemException;

    int count();

    List<TaskDto> getAllTasksOrderByTimeAsc();
    List<TaskDto> getAllTasksOrderByTimeDesc();
    List<TaskDto> getAllTasksBetween(Timestamp startDate, Timestamp endDate) throws TaskSystemException;
}
