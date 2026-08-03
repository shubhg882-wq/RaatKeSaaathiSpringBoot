package com.raatkesaaathi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raatkesaaathi.entity.User;
import com.raatkesaaathi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

}