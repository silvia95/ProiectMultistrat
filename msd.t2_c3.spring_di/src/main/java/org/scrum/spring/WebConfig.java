package org.scrum.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/mvc-configurer-default-methods.html
 */

@EnableWebMvc //
@Configuration
@ComponentScan(value="org.scrum.domain.services")
public class WebConfig implements WebMvcConfigurer {

}