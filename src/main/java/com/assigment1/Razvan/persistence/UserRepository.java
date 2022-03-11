package com.assigment1.Razvan.persistence;

import com.assigment1.Razvan.persistence.UserEntity;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository {

    EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserEntity findByName(String name) {
        List<UserEntity> users = entityManager.createQuery("SELECT e FROM UserEntity e WHERE e.name = '" + name + "'").getResultList();
        if(users.size() == 0)
            return null;
        return users.get(0);
    }

    public void save(UserEntity userEntity) {
        Session session = entityManager.unwrap(Session.class);
        entityManager.getTransaction().begin();
        entityManager.persist(userEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

}
