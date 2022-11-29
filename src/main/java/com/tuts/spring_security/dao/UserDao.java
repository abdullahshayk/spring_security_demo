package com.tuts.spring_security.dao;

import com.tuts.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Long> {

    Optional<User> findStudentByUsername(String username);

}
