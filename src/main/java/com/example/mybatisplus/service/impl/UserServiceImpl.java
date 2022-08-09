package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public void login(String pwd, String phone) {
        log.info("user login: {}", phone);
    }
}
