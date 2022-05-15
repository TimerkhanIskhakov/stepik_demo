package com.example.demo.service;

import com.example.demo.model.Myuser;

public interface UserService {

    Myuser create(Myuser myuser);
    Myuser getCurrentUser();
}
