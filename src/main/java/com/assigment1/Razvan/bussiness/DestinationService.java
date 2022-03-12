package com.assigment1.Razvan.bussiness;

import com.assigment1.Razvan.persistence.DestinationsEntity;
import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.DestinationRepository;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class DestinationService {

    DestinationRepository destinationRepository;

    public DestinationService(EntityManager entityManager) {
        this.destinationRepository = new DestinationRepository(entityManager);
    }

    public DestinationsEntity findByName(String name) {
        return destinationRepository.findByName(name);
    }
}
