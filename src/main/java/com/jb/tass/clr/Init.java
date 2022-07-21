package com.jb.tass.clr;
import com.jb.tass.bean.Task;
import com.jb.tass.dto.TaskDto;
import com.jb.tass.mapper.TaskMapper;
import com.jb.tass.repository.TaasRepository;
import com.jb.tass.repository.UserRepository;
import com.jb.tass.security.TokenManager;
import com.jb.tass.service.TaskService;
import com.jb.tass.util.Art;
import com.jb.tass.util.Testing;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.jb.tass.bean.ClientType;
import com.jb.tass.bean.User;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
@Order(1)
public class Init implements CommandLineRunner {
    private final TaasRepository taskRepository;
    private final TokenManager tokenManager;
    private final UserRepository userRepository;
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    @Override
    public void run(String... args) throws Exception {

        System.out.println(Art.SERVICE_TESTING);
        User u1 = User.builder()
                .email("admin@admin.com")
                .password("admin")
                .type(ClientType.ADMIN)
                .build();

        User u2 = User.builder()
                .email("snir@gmail.com")
                .password("1234")
                .type(ClientType.USER)
                .build();

        User u3 = User.builder()
                .email("yasmin@gmail.com")
                .password("1234")
                .type(ClientType.USER)
                .build();

        Task t1 = Task
                .builder()
                .group("Spring")
                .title("Cat & Toys Ex")
                .description("Spring Homework")
                .when(Timestamp.valueOf(LocalDateTime.now().plusWeeks(2)))
                .user(u2)
                .build();

        Task t2 = Task
                .builder()
                .group("Spring")
                .title("Author & Books Ex")
                .description("Spring Homework")
                .when(Timestamp.valueOf(LocalDateTime.now().plusWeeks(2)))
                .user(u2)
                .build();


        Task t3 = Task
                .builder()
                .group("Spring")
                .title("prepare for Spring Exam")
                .description("Spring Homework")
                .when(Timestamp.valueOf(LocalDateTime.of(2022,5,26,15,25)))
                .user(u3)
                .build();
        Testing.printCaption("add tasks");
        Task toAdd1 = Task.builder()
                .group("Web")
                .title("HTML+CSS")
                .description("Online Kit with Amit")
                .when(Timestamp.valueOf(LocalDateTime.now().plusDays(6)))
                .build();


        u2.setTasks(Arrays.asList(t1,t2));
        u3.setTasks(List.of(t3));
        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        userRepository.findAll().forEach(System.out::println);

        TaskDto toAddDto1 = taskMapper.toDto(toAdd1);

        Task toAdd2 = Task.builder()
                .group("Web")
                .title("JS")
                .description("Online Kit with Idan")
                .when(Timestamp.valueOf(LocalDateTime.now().plusDays(19)))
                .build();

        TaskDto toAddDto2 = taskMapper.toDto(toAdd2);

        taskService.addTask(toAddDto1);
        taskService.addTask(toAddDto2);
        taskService.getAllTasks().forEach(System.out::println);
        Testing.printCaption("update task");

        Task toUpdate = taskMapper.toDao(taskService.getOneTask(3));
        toUpdate.setGroup("Frontend");
        taskService.updateTask(3,taskMapper.toDto(toUpdate));
        taskService.getAllTasks().forEach(System.out::println);
        Testing.printCaption("get single task");
        try {
            System.out.println(taskService.getOneTask(8000));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(taskService.getOneTask(2));
        Testing.printCaption("count");
        System.out.println(taskService.count());
        Testing.printCaption("get all tasks");
        taskService.getAllTasks().forEach(System.out::println);
        Testing.printCaption("get all tasks by date asc");
        taskService.getAllTasksOrderByTimeAsc().forEach(System.out::println);
        Testing.printCaption("get all tasks by date desc");
        taskService.getAllTasksOrderByTimeDesc().forEach(System.out::println);
        Testing.printCaption("get all tasks between");
        Timestamp d1 = Timestamp.valueOf(LocalDateTime.now().minusDays(10));
        Timestamp d2 = Timestamp.valueOf(LocalDateTime.now().plusDays(10));
        try {
            taskService.getAllTasksBetween(d2, d1).forEach(System.out::println);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        taskService.getAllTasksBetween(d1,d2).forEach(System.out::println);
        Testing.printCaption("delete task");
//        try {
//            taskService.deleteTask(80000);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        taskService.deleteTask(1);
        taskService.getAllTasks().forEach(System.out::println);

       UUID token= tokenManager.add("yasmin@gmail.com","1234");
        System.out.println(tokenManager.getUserId(token));

    }
}