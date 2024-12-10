package com.example.demo.service;

import com.example.demo.controllers.users.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto getUserById(Long id) throws Exception {
        var userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("An error has ocurred"));
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
