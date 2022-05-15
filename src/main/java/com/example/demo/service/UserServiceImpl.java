package com.example.demo.service;

import com.example.demo.model.Myuser;
import com.example.demo.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyUserRepository myuserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Myuser create(Myuser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myuserRepository.save(user);
    }



    @Override
    public Myuser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        return myuserRepository.findByLogin(principal.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
