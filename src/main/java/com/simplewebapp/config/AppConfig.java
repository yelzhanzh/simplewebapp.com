package com.simplewebapp.config;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import org.jboss.resteasy.spi.ResteasyDeployment;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Zhangariny on 06/07/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.simplewebapp")
@PropertySource("classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {

  @Resource
  private Environment environment;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");

    return viewResolver;
  }

  @Bean(initMethod = "start", destroyMethod = "stop")
  public ResteasyDeployment resteasyDeployment() {
    ResteasyDeployment resteasyDeployment = new ResteasyDeployment();
    resteasyDeployment.setAsyncJobServiceEnabled(true);
    Map mediaTypeMapping = new HashMap();
    mediaTypeMapping.put("json", "application/json");
    mediaTypeMapping.put("xml", "application/xml");
    resteasyDeployment.setMediaTypeMappings(mediaTypeMapping);
    return  resteasyDeployment;

  }

}
