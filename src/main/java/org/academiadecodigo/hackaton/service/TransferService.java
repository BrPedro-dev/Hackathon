package org.academiadecodigo.hackaton.service;

import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Resource;

public interface TransferService {

    //transfer normal.
    void transfer(User srcUser, Resource anotherResourceSrc, Resource resourceSrc, User dstUser, Resource resourceDst, Resource anotherResourceDst, Integer amount);

    //lose current resources intended for trade.
    void loseAll(User srcUser, Resource resource, Integer amount);

    //gain 1 more resource lose 1 less.
    void transferHaggle(User srcUser,Resource anotherResourceSrc,Resource resourceSrc, User dstUser,Resource resourceDst,Resource anotherResourceDst, Integer amount);

    //resources from destination are added to user resources.
    void transferAllFromDst(User srcUser,Resource anotherResourceSrc,Resource resourceSrc, User dstUser,Resource resourceDst,Resource anotherResourceDst, Integer amount);

    //resources from source are added to dst user resources
    void transferAllFromUser(User srcUser,Resource anotherResourceSrc,Resource resourceSrc, User dstUser,Resource resourceDst,Resource anotherResourceDst, Integer amount);

    void userDies();


}
