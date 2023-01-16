package com.example.agri_back.services.serviceImp;

import com.example.agri_back.dto.UserDto;
import com.example.agri_back.model.User;
import com.example.agri_back.repositories.UserRepository;
import com.example.agri_back.services.UserService;
import com.example.agri_back.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils utils;


    @Override
    public UserDto CreateUser(UserDto userDto) {
        User user1 = userRepository.findByEmail(userDto.getEmail());
        if(user1 != null){
            throw new RuntimeException("error already exiting email");
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
//        user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setUserId(utils.generateUserId(9));
        User user2 = userRepository.save(user);
        UserDto userDto1 = new UserDto();
        BeanUtils.copyProperties(user2,userDto1);
        return userDto1;


    }

    @Override
    public UserDto getUser(String email) {
        User userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException("email not found");
        UserDto userDto1 = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto1);
        return userDto1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
