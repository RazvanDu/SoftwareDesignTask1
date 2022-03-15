package com.assigment1.Razvan.persistence;

import javax.persistence.EntityManager;
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

    public List<DestinationsEntity> getAll() {
        List<DestinationsEntity> vacations = entityManagerFactory.createEntityManager().createQuery("SELECT e FROM DestinationsEntity e").getResultList();
        return vacations;
    }

    public void save(DestinationsEntity destinationsEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(destinationsEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(DestinationsEntity destinationsEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        DestinationsEntity actualTarget = entityManager.find(DestinationsEntity.class, destinationsEntity.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(actualTarget);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
