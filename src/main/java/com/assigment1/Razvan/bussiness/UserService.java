package com.assigment1.Razvan.bussiness;

import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.UserRepository;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    UserRepository userRepository;

    private UserEntity loggedUser;

    public UserService(EntityManagerFactory entityManagerFactory) {
        this.userRepository = new UserRepository(entityManagerFactory);
    }

    public UserEntity findByName(String name) {
        return userRepository.findByName(name);
    }

    public UserEntity findById(int id) {
        return userRepository.findById(id);
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public List<VacationpackageEntity> getVacations(String name) {
        return List.copyOf(userRepository.findByName(name).getPackages());
    }

    public UserEntity getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(UserEntity loggedUser) {
        this.loggedUser = loggedUser;
    }


    public UserEntity addVacation(UserEntity userEntity, VacationpackageEntity vacationpackageEntity) {
        return userRepository.addVacation(userEntity, vacationpackageEntity);
    }
}
