package com.github.xiaoxfan.controller;


import com.github.xiaoxfan.entity.User;
import com.github.xiaoxfan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaofan
 * @date 2018/11/26 13:25
 */
@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.getOne(id);
    }
}
