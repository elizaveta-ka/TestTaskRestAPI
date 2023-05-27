package com.example.testtaskrestapi.service;

import com.example.testtaskrestapi.dto.LoginDto;
import com.example.testtaskrestapi.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
