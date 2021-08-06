package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.dtos.Dto;
import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // This Method will convert our object into User
    private Dto toUser(User user) {
        return modelMapper.map(user, Dto.class);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    private ResponseEntity<?> addUser(){
        User use = new User();
        use.setName("Hello");
        userRepository.save(use);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    private ResponseEntity<List<Dto>> getUsers(){

        return new ResponseEntity<>(userRepository.findAll()
                .stream()
                .map(this::toUser)
                .collect(Collectors.toList()),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<?> getUser(@PathVariable Integer id){

        User user = userRepository.getById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(toUser(user), HttpStatus.OK);
    }

    @GetMapping("/dAk6eD5s/{pass}")
    private ResponseEntity<?> getIntoMain(@PathVariable String pass) {
        Integer userId = 0;
        switch (pass) {
            case "uwegfy":
                userId = 1;
                break;
            case "dienf":
                userId = 2;
                break;
            case "cjeba":
                userId = 3;
                break;
            default:
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toUser(userRepository.getById(userId)), HttpStatus.OK);
    }

    @GetMapping("/user/{id}/resource")
    private ResponseEntity<?> getResources(@PathVariable Integer id){

        User user = userRepository.getById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user.getResources(),HttpStatus.OK);
    }

}
