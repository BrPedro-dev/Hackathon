package org.academiadecodigo.hackaton.service;

import org.academiadecodigo.hackaton.models.User;

public interface TransferService {

    //transfer normal.
    void transfer(User srcUser, User dstUser, Integer type, Integer amount);

    //lose current resources intended for trade.
    void loseAll(User srcUser, Integer type, Integer amount);

    //gain 1 more resource lose 1 less.
    void transferHaggle(User srcUser, User dstUser, Integer type, Integer amount);

    //resources from destination are added to user resources.
    void transferAllFromDst(User srcUser, User dstUser, Integer type, Integer amount);

    //resources from source are added to dst user resources
    void transferAllFromUser(User srcUser, User dstUser, Integer type, Integer amount);

    void userDies();


}
