package com.assigment1.Razvan;

import com.assigment1.Razvan.bussiness.DestinationService;
import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.VacationpackageEntity;
import com.assigment1.Razvan.presentation.LoginForm;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Assigment1");

        UserService userService = new UserService(entityManagerFactory);
        VacationsService vacationpackageService = new VacationsService(entityManagerFactory);
        DestinationService destinationService = new DestinationService(entityManagerFactory);

        new LoginForm(userService, vacationpackageService, destinationService);

        UserEntity user = userService.findByName("razvan");

        for(VacationpackageEntity vacation : user.getPackages()) {
            System.out.println(vacation.getName());
        }

        //System.out.println(user.getPackages().size());

    }
}
