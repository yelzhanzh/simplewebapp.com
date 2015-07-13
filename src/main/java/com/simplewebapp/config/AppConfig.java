package com.simplewebapp.config;

import javax.annotation.Resource;

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

//  @Override
//  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    configurer.favorPathExtension(true)
//      .useJaf(false)
//      .ignoreAcceptHeader(true)
//      .mediaType("html", MediaType.TEXT_HTML)
//      .mediaType("json", MediaType.APPLICATION_JSON)
//      .defaultContentType(MediaType.TEXT_HTML);
//  }
//
//  @Bean
//  public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
//
//    List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
//
//    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//    internalResourceViewResolver.setPrefix("WEB-INF/views/");
//    internalResourceViewResolver.setSuffix(".jsp");
//    internalResourceViewResolver.setViewClass(JstlView.class);
//
//    JsonViewResolver jsonViewResolver = new JsonViewResolver();
//    viewResolvers.add(jsonViewResolver);
//
//    ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
//    viewResolver.setViewResolvers(viewResolvers);
//    viewResolver.setContentNegotiationManager(manager);
//
//    return viewResolver;
//  }
//
//  public class JsonViewResolver implements ViewResolver {
//    public View resolveViewName(String viewName, Locale locale) throws Exception {
//      MappingJackson2JsonView view = new MappingJackson2JsonView();
//      view.setPrettyPrint(true);
//      return view;
//    }
//  }

}
