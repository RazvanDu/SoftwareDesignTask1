package com.assigment1.Razvan;

import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.presentation.LoginForm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Assigment1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<UserEntity> users = entityManager.createQuery("SELECT e FROM UserEntity e").getResultList();

        LoginForm f = new LoginForm();

    }
}
