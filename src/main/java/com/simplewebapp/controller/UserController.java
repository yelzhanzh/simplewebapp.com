package com.simplewebapp.controller;

import java.util.List;

import com.simplewebapp.model.User;
import com.simplewebapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Zhangariny on 06/07/2015.
 */
@Controller
public class UserController {
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value="/user/add")
  public ModelAndView addUserPage() {
    ModelAndView modelAndView = new ModelAndView("add-user-form");
    modelAndView.addObject("user", new User());
    return modelAndView;
  }

  @RequestMapping(value="/user/add/process")
  public ModelAndView addingUser(@ModelAttribute User user) {

    ModelAndView modelAndView = new ModelAndView("home");
    userService.addUser(user);

    String message = "User was successfully added.";
    modelAndView.addObject("message", message);

    return modelAndView;
  }

  @RequestMapping(value="/user/list")
  public ModelAndView listOfUsers() {
    ModelAndView modelAndView = new ModelAndView("list-of-users");

    List<User> users = userService.getUsers();
    modelAndView.addObject("users", users);

    return modelAndView;
  }

  @RequestMapping(value="/user/edit/{id}", method = RequestMethod.GET)
  public ModelAndView editUserPage(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("edit-user-form");
    User user = userService.getUser(id);
    modelAndView.addObject("user", user);

    return modelAndView;
  }

  @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
  public ModelAndView edittingUser(@ModelAttribute User user, @PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("home");

    userService.updateUser(user);

    String message = "User was successfully updated.";
    modelAndView.addObject("message", message);

    return modelAndView;
  }

  @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
  public ModelAndView deleteUser(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("user");

    userService.deleteUser(id);

    String message = "User was successfully deleted.";

    modelAndView.addObject("message", message);
    return modelAndView;
  }

}
