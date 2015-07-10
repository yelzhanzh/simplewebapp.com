package com.simplewebapp.dao;

import java.util.List;

import com.simplewebapp.model.User;

/**
 * Created by Zhangariny on 10/07/2015.
 */
public interface UserDAO {

  public void addUser(User user);

  public void updateUser(User user);

  public User getUser(int id);

  public void deleteUser(int id);

  public List<User> getUsers();

}
