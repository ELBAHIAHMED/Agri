package com.example.agri_back.contoller;

import com.example.agri_back.dto.UserDto;
import com.example.agri_back.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("create")
    private ResponseEntity<UserDto> CreateUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.CreateUser(userDto);
        return new ResponseEntity<>(userDto1,HttpStatus.ACCEPTED) ;

    }
}
