package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Gas;
import org.academiadecodigo.hackaton.models.resources.Water;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/getUser")
    private ResponseEntity<User> getUSer(){

        User user = new User();
        user.setName("J");

        userRepository.save(user);

        return new ResponseEntity<>(userRepository.getById(1), HttpStatus.OK);
    }
}
