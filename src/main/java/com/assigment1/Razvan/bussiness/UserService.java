package com.assigment1.Razvan.bussiness;

import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.UserRepository;

import javax.persistence.EntityManager;

public class UserService {

    UserRepository userRepository;

    public UserService(EntityManager entityManager) {
        this.userRepository = new UserRepository(entityManager);
    }

    public UserEntity findByName(String name) {
        return userRepository.findByName(name);
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

}
