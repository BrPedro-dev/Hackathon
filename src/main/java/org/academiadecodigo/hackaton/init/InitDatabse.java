package org.academiadecodigo.hackaton.init;


import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


public class InitDatabse {


    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(){
        User user1 = new User();
        user1.setName("User1");
        userRepository.save(user1);

        User user2= new User();
        user2.setName("User2");
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("User3");
        userRepository.save(user3);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").format(new Date()) + " ***INFO*** USERS ADDS IN DATABASE" );
    }
}
