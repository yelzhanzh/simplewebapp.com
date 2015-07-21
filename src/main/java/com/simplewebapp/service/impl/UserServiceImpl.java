package com.simplewebapp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.simplewebapp.dao.UserDAO;
import com.simplewebapp.model.User;
import com.simplewebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zhangariny on 10/07/2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;

  public void addUser(User user) {
    //TODO do some checks before "insert"
    userDAO.addUser(user);
  }

  public void updateUser(User user) {
    userDAO.updateUser(user);
  }

  public User getUser(int id) {
    return userDAO.getUser(id);
  }

  public void deleteUser(int id) {
    userDAO.deleteUser(id);
  }

  public List<User> getUsers() {
    return userDAO.getUsers();
  }
}
