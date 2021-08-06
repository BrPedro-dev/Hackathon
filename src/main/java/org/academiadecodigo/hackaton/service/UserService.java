package org.academiadecodigo.hackaton.service;

import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Resource;

public interface UserService {


    void trade(User srcUser, Resource anotherResourceSrc, Resource resourceSrc, User dstUser, Resource resourceDst, Resource anotherResourceDst, Integer amount);

}
