package com.simplewebapp.service;

import java.util.List;

import com.simplewebapp.model.User;

/**
 * Created by Zhangariny on 10/07/2015.
 */
public interface UserService {

  void addUser(User user);

  void updateUser(User user);

  User getUser(int id);

  void deleteUser(int id);

  List<User> getUsers();

}
