package com.sadique.task_api.repository;

import com.sadique.task_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByuserName(String userName);
    void deleteByUserName(String userName);
}
