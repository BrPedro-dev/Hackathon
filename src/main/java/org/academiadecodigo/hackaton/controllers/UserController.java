package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class UserController {


    // ModelMapper
    @Autowired
    private UserRepository userRepository;

    // ModelMapper
    @Autowired
    private ModelMapper modelMapper;

    // This Method will convert our object into User
    private User toUser(User user) {
        return modelMapper.map(user, User.class);
    }

    @GetMapping
    private ResponseEntity<User> findAllUsers() {
        return (ResponseEntity<User>) userRepository.findAll()
                .stream()
                .map(this::toUser);

    }

    @GetMapping("/getUser")
     private ResponseEntity<User> getUSer(){

        User user = new User();
        user.setName("J");

        userRepository.save(user);

        return new ResponseEntity<>(userRepository.getById(1), HttpStatus.OK);
    }
}
