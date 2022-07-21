package com.jb.tass.controller;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.dto.TaskPayLoadDto;
import com.jb.tass.exception.TaskSecurityException;
import com.jb.tass.exception.TaskSystemException;
import com.jb.tass.security.TokenManager;
import com.jb.tass.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//Created by sniryosefof on 30 יוני
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenManager tokenManger;
//    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks(@RequestHeader("Authorization")UUID token) throws TaskSecurityException {
        int userId = tokenManger.getUserId(token);
        return userService.getAllTasks(userId);
    }

    @PostMapping("/tasks")
    public void addTask(@RequestHeader("Authorization")UUID token,@RequestBody TaskDto taskDto) throws TaskSecurityException, TaskSystemException {
        int userId = tokenManger.getUserId(token);
        userService.addTask(userId, taskDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TaskDto updateTask(@PathVariable int id, @RequestBody TaskPayLoadDto taskDto) throws TaskSystemException {
        return userService.updateTask(id, new TaskDto(taskDto));
    }

    @GetMapping("/count")
    public int count(@RequestHeader("Authorization")UUID token) {
        return userService.countById();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@RequestHeader("Authorization")UUID token,@PathVariable int id) throws TaskSystemException {
        userService.deleteTask(id);
    }


}
