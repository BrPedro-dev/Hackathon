package org.academiadecodigo.hackaton;

import org.academiadecodigo.hackaton.init.InitDatabse;
import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Gas;
import org.academiadecodigo.hackaton.models.resources.Water;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HackatoonApplication {

    public static void main(String[] args) {

        // If you don't need to populate the database apply the code line below and comment the others
        // SpringApplication.run(HackatoonApplication.class, args);

        //Populate the database
        ConfigurableApplicationContext context = SpringApplication.run(HackatoonApplication.class, args);
        InitDatabse initDatabse = context.getBean(InitDatabse.class);
        initDatabse.addUser();
    }


}
