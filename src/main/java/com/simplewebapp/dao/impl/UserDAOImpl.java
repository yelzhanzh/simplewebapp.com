package com.simplewebapp.dao.impl;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.simplewebapp.dao.UserDAO;
import com.simplewebapp.model.User;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by Zhangariny on 10/07/2015.
 */
@Repository
public class UserDAOImpl implements UserDAO {

  @PersistenceContext
  private EntityManager entityManager;


  public void addUser(User user) {
    this.entityManager.persist(user);
  }

  public void updateUser(User user) {
    this.entityManager.merge(user);
  }

  public User getUser(int id) {
    return this.entityManager.find(User.class, id);
  }

  public List<User> getUsers() {
    Query query = this.entityManager.createQuery("SELECT e FROM User e");
    return (List<User>) query.getResultList();
  }

  public void deleteUser(int id) {
    User user = this.entityManager.find(User.class, id);
    this.entityManager.remove(user);
  }

}
