package org.academiadecodigo.hackaton.controllers;

import org.academiadecodigo.hackaton.dtos.Dto;
import org.academiadecodigo.hackaton.dtos.TransferDTO;
import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Resource;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.academiadecodigo.hackaton.service.ServiceImpl;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private ServiceImpl serviceImpl;
    private int userId;


    // This Method will convert our object into User
    private Dto toUser(User user) {
        return modelMapper.map(user, Dto.class);
    }

    @Autowired
    public void setServiceImpl(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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

    @RequestMapping(method = RequestMethod.GET, path = "/dAk6eD5s/{pass}.")
    private ResponseEntity<?> getIntoMain(@PathVariable String pass) {

        userId = 0;
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

    @GetMapping("/user/{id}/resource.")
    private ResponseEntity<?> getResources(@PathVariable Integer id){

        User user = userRepository.getById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user.getResources(),HttpStatus.OK);
    }

    @PutMapping("user/{userId}/{Id}.")
    private ResponseEntity<?> getTrade(@PathVariable Integer userId, @PathVariable String Id, @RequestBody TransferDTO transferDTO){


        User srcUser = userRepository.getById(userId);

        Optional<Resource> anotherResourceSrc = srcUser.getResources().stream().filter(resource -> !resource.getName().equals(transferDTO.getResourceSrc())).findFirst();

        User dstUser = userRepository.getById(idConverter(Id));

        Optional<Resource> anotherResourceDst = dstUser.getResources().stream().filter(resource -> !resource.getName().equals(transferDTO.getResourceDst())).findFirst();

        Optional<Resource> resourceSrc = srcUser.getResources().stream().filter(resource -> resource.getName().equals(transferDTO.getResourceSrc())).findFirst();

        Optional<Resource> resourceDst = dstUser.getResources().stream().filter(resource -> resource.getName().equals(transferDTO.getResourceDst())).findFirst();


        if(dstUser == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        serviceImpl.trade(srcUser, anotherResourceSrc.get(), resourceSrc.get(), dstUser, resourceDst.get(), anotherResourceDst.get(), transferDTO.getAmount());

        return new ResponseEntity<>(HttpStatus.OK);

    }

    private Integer idConverter(String pass){
        userId = 0;
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
                return 0;
        }
        return userId;
    }


}
