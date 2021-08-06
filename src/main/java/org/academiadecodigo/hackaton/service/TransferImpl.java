package org.academiadecodigo.hackaton.service;

import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Gas;
import org.academiadecodigo.hackaton.models.resources.Resource;
import org.academiadecodigo.hackaton.models.resources.Water;
import org.academiadecodigo.hackaton.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TransferImpl implements TransferService {


    private UserRepository userRepository;

    private Resource resource;
    private User user;


    @Transactional
    @Override
    public void transfer(User srcUser,Resource anotherResourceSrc,Resource resourceSrc, User dstUser,Resource resourceDst,Resource anotherResourceDst, Integer amount) {

            if(anotherResourceSrc.getQuantity() != 0 && resourceDst.getQuantity() != 0){

                anotherResourceSrc.setQuantity(anotherResourceSrc.getQuantity() - amount);
                resourceSrc.setQuantity(resourceSrc.getQuantity() + amount);

                resourceDst.setQuantity(resourceDst.getQuantity() - amount);
                anotherResourceDst.setQuantity(anotherResourceDst.getQuantity() + amount);

                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        }


    @Transactional
    @Override
    public void loseAll(User srcUser, Resource resource, Integer amount) {

        if(resource.getQuantity() != 0){
            resource.setQuantity(resource.getQuantity() - amount);
            userRepository.saveAndFlush(srcUser);
        }

    }

    @Transactional
    @Override
    public void transferHaggle(User srcUser,Resource anotherResourceSrc,Resource resourceSrc, User dstUser,Resource resourceDst,Resource anotherResourceDst, Integer amount) {
        if(anotherResourceSrc.getQuantity() != 0 && resourceDst.getQuantity() != 0){

            anotherResourceSrc.setQuantity(anotherResourceSrc.getQuantity() - (amount-1));
            resourceSrc.setQuantity(resourceSrc.getQuantity() + (amount + 1));

            resourceDst.setQuantity(resourceDst.getQuantity() - (amount + 1));
            anotherResourceDst.setQuantity(anotherResourceDst.getQuantity() + (amount - 1));

            userRepository.saveAndFlush(srcUser);
            userRepository.saveAndFlush(dstUser);
        }
    }

    @Transactional
    @Override
    public void transferAllFromDst(User srcUser,Resource anotherResourceSrc,Resource resourceSrc, User dstUser,Resource resourceDst,Resource anotherResourceDst, Integer amount) {


        if(anotherResourceSrc.getQuantity() != 0 && resourceDst.getQuantity() != 0){

            anotherResourceSrc.setQuantity(anotherResourceSrc.getQuantity() + amount);
            resourceSrc.setQuantity(resourceSrc.getQuantity() + amount);

            resourceDst.setQuantity(resourceDst.getQuantity() - amount);
            anotherResourceDst.setQuantity(anotherResourceDst.getQuantity() - amount);

            userRepository.saveAndFlush(srcUser);
            userRepository.saveAndFlush(dstUser);
        }

    }


    @Transactional
    @Override
    public void transferAllFromUser(User srcUser,Resource anotherResourceSrc,Resource resourceSrc, User dstUser,Resource resourceDst,Resource anotherResourceDst, Integer amount) {

        if(anotherResourceSrc.getQuantity() != 0 && resourceDst.getQuantity() != 0){

            resourceDst.setQuantity(resourceDst.getQuantity() + anotherResourceSrc.getQuantity());
            anotherResourceDst.setQuantity(anotherResourceDst.getQuantity() + resourceDst.getQuantity());


            anotherResourceSrc.setQuantity(0);
            resourceSrc.setQuantity(0);



            userRepository.saveAndFlush(srcUser);
            userRepository.saveAndFlush(dstUser);
        }
    }
    @Transactional
    @Override
    public void userDies() {
        System.out.println("You feel death coiling around.");
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
