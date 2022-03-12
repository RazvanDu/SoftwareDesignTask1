package com.assigment1.Razvan.persistence;

import javax.persistence.EntityManager;
import java.util.List;

public class DestinationRepository {

    EntityManager entityManager;

    public DestinationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DestinationsEntity findByName(String name) {
        List<DestinationsEntity> destinations = entityManager.createQuery("SELECT e FROM DestinationsEntity e WHERE e.name = '" + name + "'").getResultList();
        if(destinations.size() == 0)
            return null;
        return destinations.get(0);
    }

}
