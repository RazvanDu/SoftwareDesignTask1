package com.assigment1.Razvan.persistence;

import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.persistence.VacationpackageEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class VacationpackageRepository {

    EntityManager entityManager;

    public VacationpackageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<VacationpackageEntity> getAll() {
        List<VacationpackageEntity> vacations = entityManager.createQuery("SELECT e FROM VacationpackageEntity e").getResultList();
        return vacations;
    }

    public VacationpackageEntity findById(int id) {
        List<VacationpackageEntity> users = entityManager.createQuery("SELECT e FROM VacationpackageEntity e WHERE e.id = '" + id + "'").getResultList();
        if(users.size() == 0)
            return null;
        return users.get(0);
    }

    public void save(VacationpackageEntity vacationpackageEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(vacationpackageEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

}
