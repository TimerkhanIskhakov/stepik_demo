package com.example.demo.controller;

import com.example.demo.model.Myuser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {

    @Autowired()
    private UserService userService;

    @PostMapping("/users")
    public Myuser create(@RequestBody Myuser myuser) {
        return userService.create(myuser);
    }
}
