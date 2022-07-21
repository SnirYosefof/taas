package com.jb.tass.repository;

import com.jb.tass.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Created by sniryosefof on 30 יוני
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email,String password);
    User findTop1ByEmail(String email);
    @Query( value = "SELECT count(id) FROM tass.tasks where user_id=2;",nativeQuery = true)
    int getCountById(int id);
}
