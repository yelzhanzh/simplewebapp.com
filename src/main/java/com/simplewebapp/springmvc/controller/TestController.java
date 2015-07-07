package com.simplewebapp.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Zhangariny on 06/07/2015.
 */
@Controller
@RequestMapping("/")
public class TestController {
  private static final Logger logger = LoggerFactory.getLogger(TestController.class);

  @RequestMapping(method = RequestMethod.GET)
  public  String sayHello(ModelMap model) {
    model.addAttribute("greeting", "Hello");
    return "index";
  }

}
