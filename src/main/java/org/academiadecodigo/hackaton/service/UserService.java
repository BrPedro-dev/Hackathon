package org.academiadecodigo.hackaton.service;

import org.academiadecodigo.hackaton.models.User;

public interface UserService {


    void trade(User srcUser, User dstUser, Integer type, Integer amount );

}
