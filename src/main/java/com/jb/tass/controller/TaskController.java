package com.jb.tass.controller;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.dto.TaskPayLoadDto;
import com.jb.tass.exception.TaskSystemException;
import com.jb.tass.models.DateBetweenReqReq;
import com.jb.tass.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Created by sniryosefof on 29 יוני
@RestController
@RequestMapping("api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto addTask(@Valid @RequestBody TaskPayLoadDto taskDto) throws TaskSystemException {
        return taskService.addTask(new TaskDto(taskDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TaskDto updateTask(@PathVariable int id, @RequestBody TaskPayLoadDto taskDto) throws TaskSystemException {
         return taskService.updateTask(id, new TaskDto(taskDto));
    }

    @GetMapping
    public List<TaskDto> getAllTask() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDto getOneTask(@PathVariable int id) throws TaskSystemException {
        return taskService.getOneTask(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) throws TaskSystemException {
        taskService.deleteTask(id);
    }

    @GetMapping("/count")
    public int count() {
        return taskService.count();
    }

    @GetMapping("/sorted/time/asc")
    public List<TaskDto> getAllAsc() {
        return taskService.getAllTasksOrderByTimeAsc();
    }

    @GetMapping("/sorted/time/desc")
    public List<TaskDto> getAllDesc() {
        return taskService.getAllTasksOrderByTimeDesc();
    }

    @GetMapping("/btw/dates")
    public List<TaskDto> getAllTaskBetween(@RequestBody DateBetweenReqReq dateBetween) throws TaskSystemException {
        return taskService.getAllTasksBetween(dateBetween.getStart(), dateBetween.getEnd());
    }
}
