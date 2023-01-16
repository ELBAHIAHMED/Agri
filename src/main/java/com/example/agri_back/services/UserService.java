package com.example.agri_back.services;

import com.example.agri_back.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {

    UserDto CreateUser(UserDto userDto);

    UserDto getUser(String userName);
}
