package com.github.xiaoxfan.controller;

import com.github.xiaoxfan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaofan
 * @date 2018/11/26 14:06
 */
@RestController
public class MovieController {
    private final RestTemplate restTemplate;

    @Autowired
    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/movies/{id}")
    public User findById(@PathVariable Long id) {
        //调用用户的service接口
        return this.restTemplate.getForObject("http://127.0.0.1:7900/users/" + id, User.class);
    }
}
