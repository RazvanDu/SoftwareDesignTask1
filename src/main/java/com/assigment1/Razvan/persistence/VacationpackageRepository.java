package com.assigment1.Razvan.persistence;

import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class VacationpackageRepository {

    EntityManagerFactory entityManagerFactory;

    public VacationpackageRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<VacationpackageEntity> getAll() {
        List<VacationpackageEntity> vacations = entityManagerFactory.createEntityManager().createQuery("SELECT e FROM VacationpackageEntity e").getResultList();
        return vacations;
    }

    public VacationpackageEntity findById(int id) {
        List<VacationpackageEntity> users = entityManagerFactory.createEntityManager().createQuery("SELECT e FROM VacationpackageEntity e WHERE e.id = '" + id + "'").getResultList();
        if(users.size() == 0)
            return null;
        return users.get(0);
    }

    public void save(VacationpackageEntity vacationpackageEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(vacationpackageEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
