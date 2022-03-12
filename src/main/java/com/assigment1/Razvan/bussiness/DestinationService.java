package com.assigment1.Razvan.bussiness;

import com.assigment1.Razvan.persistence.DestinationsEntity;
import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.DestinationRepository;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class DestinationService {

    DestinationRepository destinationRepository;

    public DestinationService(EntityManagerFactory entityManagerFactory) {
        this.destinationRepository = new DestinationRepository(entityManagerFactory);
    }

    public DestinationsEntity findByName(String name) {
        return destinationRepository.findByName(name);
    }
}
