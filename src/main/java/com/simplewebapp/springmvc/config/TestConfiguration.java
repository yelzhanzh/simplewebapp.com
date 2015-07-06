package com.simplewebapp.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Zhangariny on 06/07/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.simplewebapp.springmvc")
public class TestConfiguration {
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("WEB-INF/views/");
    viewResolver.setSuffix(".jsp");

    return viewResolver;
  }

}
