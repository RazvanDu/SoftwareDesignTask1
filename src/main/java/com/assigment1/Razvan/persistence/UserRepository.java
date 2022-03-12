package com.assigment1.Razvan.persistence;

import com.assigment1.Razvan.persistence.UserEntity;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    public void save(UserEntity userEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
