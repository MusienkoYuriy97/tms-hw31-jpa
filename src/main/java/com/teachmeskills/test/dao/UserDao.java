package com.teachmeskills.test.dao;

import com.teachmeskills.test.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user){
        entityManager.persist(user);
    }

    public List<User> getAll(){
        return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public boolean existByUsername(String username){
        Long singleResult = entityManager.createNamedQuery("User.existByUsername", Long.class)
                .setParameter("username", username)
                .getSingleResult();
        return singleResult > 0;
    }

    public boolean existById(long id){
        Long singleResult = entityManager.createNamedQuery("User.existById", Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return singleResult > 0;
    }

    public void update(User user){
        entityManager.merge(user);
    }

    public void delete(long id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public Optional<User> getById(long id){
        User singleResult = entityManager
                .createNamedQuery("User.getById", User.class)
                .setParameter("id", id)
                .getSingleResult();
        return Optional.of(singleResult);
    }

//    public void updateAddress(Address address) {
//        entityManager.createNamedQuery("User.updateAddress")
//                .setParameter("street", address.getStreet())
//                .setParameter("id", address.getId())
//                .executeUpdate();
//    }
}
