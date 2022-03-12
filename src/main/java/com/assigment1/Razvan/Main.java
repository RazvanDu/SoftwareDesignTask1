package com.assigment1.Razvan;

import com.assigment1.Razvan.bussiness.DestinationService;
import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.VacationpackageEntity;
import com.assigment1.Razvan.presentation.LoginForm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Assigment1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserService userService = new UserService(entityManager);
        VacationsService vacationpackageService = new VacationsService(entityManager);
        DestinationService destinationService = new DestinationService(entityManager);

        new LoginForm(userService, vacationpackageService, destinationService);

        UserEntity user = userService.findByName("razvan");

        for(VacationpackageEntity vacation : user.getPackages()) {
            System.out.println(vacation.getName());
        }

        //System.out.println(user.getPackages().size());

    }
}
