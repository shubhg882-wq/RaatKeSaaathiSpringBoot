package com.raatkesaaathi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raatkesaaathi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}