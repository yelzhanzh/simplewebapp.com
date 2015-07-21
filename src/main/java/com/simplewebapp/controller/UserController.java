package com.simplewebapp.controller;

import java.util.List;

import javax.ws.rs.*;

import com.simplewebapp.model.User;
import com.simplewebapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Zhangariny on 06/07/2015.
 */
@Controller
@Path("/user")
public class UserController {
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @GET
  @Path("/")
  @RequestMapping
  public ModelAndView homePage() {
    ModelAndView modelAndView = new ModelAndView("home");

    return modelAndView;
  }

  @GET
  @Path("/add")
  public ModelAndView addUserPage() {
    ModelAndView modelAndView = new ModelAndView("add-user-form");
    modelAndView.addObject("user", new User());
    return modelAndView;
  }

  @POST
  @Path("/add")
  public ModelAndView addingUser(@ModelAttribute User user) {

    ModelAndView modelAndView = new ModelAndView("home");
    userService.addUser(user);

    String message = "User was successfully added.";
    modelAndView.addObject("message", message);

    return modelAndView;
  }

  @GET
  @Path("/user/list")
  public ModelAndView listOfUsers() {
    ModelAndView modelAndView = new ModelAndView("list-of-users");

    List<User> users = userService.getUsers();
    modelAndView.addObject("users", users);

    return modelAndView;
  }

  @GET
  @Path(value = "/edit/{id}")
  public ModelAndView editUserPage(@PathParam("id") int id) {
    ModelAndView modelAndView = new ModelAndView("edit-user-form");
    User user = userService.getUser(id);
    modelAndView.addObject("user", user);

    return modelAndView;
  }

  @PUT
  @Path(value = "/edit/{id}")
  public ModelAndView edittingUser(@ModelAttribute User user, @PathParam("id") int id) {
    ModelAndView modelAndView = new ModelAndView("home");

    userService.updateUser(user);

    String message = "User was successfully updated.";
    modelAndView.addObject("message", message);

    return modelAndView;
  }

  @DELETE
  @Path("/delete/{id}")
  public ModelAndView deleteUser(@PathParam("id") int id) {
    ModelAndView modelAndView = new ModelAndView("home");

    userService.deleteUser(id);

    String message = "User was successfully deleted.";

    modelAndView.addObject("message", message);
    return modelAndView;
  }

}
