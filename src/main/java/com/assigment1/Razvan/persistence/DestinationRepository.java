package com.assigment1.Razvan.persistence;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class DestinationRepository {

    EntityManagerFactory entityManagerFactory;

    public DestinationRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public DestinationsEntity findByName(String name) {
        List<DestinationsEntity> destinations = entityManagerFactory.createEntityManager().createQuery("SELECT e FROM DestinationsEntity e WHERE e.name = '" + name + "'").getResultList();
        if(destinations.size() == 0)
            return null;
        return destinations.get(0);
    }

}
