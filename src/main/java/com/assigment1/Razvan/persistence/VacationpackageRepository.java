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

}
