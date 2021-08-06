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
    public void transfer(User srcUser, User dstUser, Integer type, Integer amount) {

        List<Resource> srcUserResources = srcUser.getResources();
        List<Resource> dstUserResources = dstUser.getResources();

        if(type == 1){

            Resource srcWater = srcUserResources.get(1);
            Resource dstWater = dstUserResources.get(1);
            Water sourceWater = (Water) srcWater;
            Water DestinationWater = (Water) dstWater;

            if(sourceWater.getLts() != 0 && DestinationWater.getLts() != 0){
                sourceWater.setLts(sourceWater.getLts() - amount);
                DestinationWater.setLts(DestinationWater.getLts() + amount);
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        } if (type == 0 ){
            Resource srcGas = srcUserResources.get(0);
            Resource dstGas = dstUserResources.get(0);
            Gas SourceGas = (Gas) srcGas;
            Gas DestinationGas = (Gas) dstGas;

            if(SourceGas.getGalons() != 0 && DestinationGas.getGalons() != 0){
                SourceGas.setGalons(SourceGas.getGalons() - amount);
                DestinationGas.setGalons(SourceGas.getGalons() + amount);
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        }
    }

    @Transactional
    @Override
    public void loseAll(User srcUser, Integer type, Integer amount) {

        List<Resource> srcUserResources = srcUser.getResources();

        if (type == 1) {
            Resource srcWater = srcUserResources.get(1);
            Water sourceWater = (Water) srcWater;

            if (sourceWater.getLts() != 0) {
                sourceWater.setLts(sourceWater.getLts() - amount);
                userRepository.saveAndFlush(srcUser);
            }

        }if (type == 0 ){
            Resource srcGas = srcUserResources.get(0);
            Gas SourceGas = (Gas) srcGas;

            if(SourceGas.getGalons() != 0){
                SourceGas.setGalons(SourceGas.getGalons() - amount);
                userRepository.saveAndFlush(srcUser);
            }
        }
    }

    @Transactional
    @Override
    public void transferHaggle(User srcUser, User dstUser, Integer type, Integer amount) {
        List<Resource> srcUserResources = srcUser.getResources();
        List<Resource> dstUserResources = dstUser.getResources();

        if(type == 1){

            Resource srcWater = srcUserResources.get(1);
            Resource dstWater = dstUserResources.get(1);
            Water sourceWater = (Water) srcWater;
            Water DestinationWater = (Water) dstWater;

            if(sourceWater.getLts() != 0 && DestinationWater.getLts() != 0){
                sourceWater.setLts(sourceWater.getLts() - amount +(1));
                DestinationWater.setLts(DestinationWater.getLts() + amount -(1));
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        } if (type == 0 ){
            Resource srcGas = srcUserResources.get(0);
            Resource dstGas = dstUserResources.get(0);
            Gas SourceGas = (Gas) srcGas;
            Gas DestinationGas = (Gas) dstGas;

            if(SourceGas.getGalons() != 0 && DestinationGas.getGalons() != 0){
                SourceGas.setGalons(SourceGas.getGalons() - amount +(1));
                DestinationGas.setGalons(SourceGas.getGalons() + amount -(1));
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        }
    }

    @Transactional
    @Override
    public void transferAllFromDst(User srcUser, User dstUser, Integer type, Integer amount) {

        List<Resource> srcUserResources = srcUser.getResources();
        List<Resource> dstUserResources = dstUser.getResources();

        if(type == 1){

            Resource srcWater = srcUserResources.get(1);
            Resource dstWater = dstUserResources.get(1);
            Water sourceWater = (Water) srcWater;
            Water DestinationWater = (Water) dstWater;

            if(sourceWater.getLts() != 0 && DestinationWater.getLts() != 0){
                sourceWater.setLts(sourceWater.getLts() + amount);
                DestinationWater.setLts(DestinationWater.getLts() - amount );
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        } if (type == 0 ){
            Resource srcGas = srcUserResources.get(0);
            Resource dstGas = dstUserResources.get(0);
            Gas SourceGas = (Gas) srcGas;
            Gas DestinationGas = (Gas) dstGas;

            if(SourceGas.getGalons() != 0 && DestinationGas.getGalons() != 0){
                SourceGas.setGalons(SourceGas.getGalons() + amount );
                DestinationGas.setGalons(SourceGas.getGalons() - amount );
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        }
    }


    @Transactional
    @Override
    public void transferAllFromUser(User srcUser, User dstUser, Integer type, Integer amount) {

        List<Resource> srcUserResources = srcUser.getResources();
        List<Resource> dstUserResources = dstUser.getResources();

        if(type == 1){

            Resource srcWater = srcUserResources.get(1);
            Resource dstWater = dstUserResources.get(1);
            Water sourceWater = (Water) srcWater;
            Water DestinationWater = (Water) dstWater;

            if(sourceWater.getLts() != 0 && DestinationWater.getLts() != 0){
                sourceWater.setLts(sourceWater.getLts() - amount);
                DestinationWater.setLts(DestinationWater.getLts() + amount );
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
        } if (type == 0 ){
            Resource srcGas = srcUserResources.get(0);
            Resource dstGas = dstUserResources.get(0);
            Gas SourceGas = (Gas) srcGas;
            Gas DestinationGas = (Gas) dstGas;

            if(SourceGas.getGalons() != 0 && DestinationGas.getGalons() != 0){
                SourceGas.setGalons(SourceGas.getGalons() - amount );
                DestinationGas.setGalons(SourceGas.getGalons() + amount );
                userRepository.saveAndFlush(srcUser);
                userRepository.saveAndFlush(dstUser);
            }
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
