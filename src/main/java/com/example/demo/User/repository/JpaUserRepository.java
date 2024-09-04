package com.example.demo.User.repository;

import com.example.demo.User.domain.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository{

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> findByUserId(String id) {
        return em.createQuery("select u from User u where u.userid = :userid", User.class)
                .setParameter("userid",id)
                .getResultList();
    }

    @Override
    public boolean existByUserId(String userid) {
        Long user_count = em.createQuery("select count(u) from User u where u.userid = :userid", Long.class)
                .setParameter("userid",userid)
                .getSingleResult();
        return user_count>0;
    }

    @Override
    public boolean existByUserIdAndPassword(String userid, String password) {
        Long user_count = em.createQuery("select count(u) from User u where u.userid = :userid and u.password = :password", Long.class)
                .setParameter("userid",userid)
                .setParameter("password",password)
                .getSingleResult();
        return user_count>0;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }
}
