package com.jb.tass.bean;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Created by sniryosefof on 30 יוני
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private ClientType type;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "user")
    @Singular
    private List<Task> tasks  = new ArrayList<>();
}
