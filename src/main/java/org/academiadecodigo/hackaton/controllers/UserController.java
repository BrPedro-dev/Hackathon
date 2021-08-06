package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Gas;
import org.academiadecodigo.hackaton.models.resources.Water;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserRepository userRepository;

    private TransferImpl transfer;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setTransfer(TransferImpl transfer) {
        this.transfer = transfer;
    }

    @GetMapping("/trade")
    private ResponseEntity<?> getUsers(){
        transfer.transfer(userRepository.getById(1),userRepository.getById(4),1,10);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    private ResponseEntity<?> getUsersss(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<?> getUser(@PathVariable Integer id){

        User user = userRepository.getById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }



}
