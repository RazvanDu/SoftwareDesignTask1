package com.assigment1.Razvan.persistence;

import com.assigment1.Razvan.persistence.UserEntity;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepository {

    EntityManagerFactory entityManagerFactory;

    public UserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public UserEntity findByName(String name) {
        List<UserEntity> users = entityManagerFactory.createEntityManager().createQuery("SELECT e FROM UserEntity e WHERE e.name = '" + name + "'").getResultList();
        if(users.size() == 0)
            return null;
        return users.get(0);
    }

    public UserEntity findById(int id) {
        return entityManagerFactory.createEntityManager().find(UserEntity.class, id);
    }

    public void save(UserEntity userEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(userEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public UserEntity addVacation(UserEntity userEntity, VacationpackageEntity vacationpackageEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserEntity managedEntity = entityManager.find(UserEntity.class, userEntity.getId());
        entityManager.refresh(managedEntity);

        entityManager.getTransaction().begin();
        managedEntity.getPackages().add(vacationpackageEntity);
        entityManager.persist(managedEntity);

        //entityManager.unwrap(org.hibernate.Session.class).merge(userEntity);
        //entityManager.unwrap(org.hibernate.Session.class).update(userEntity);

        //entityManager.persist(userEntity);
        //entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        return managedEntity;
    }

}
