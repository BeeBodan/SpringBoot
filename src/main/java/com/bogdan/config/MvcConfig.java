package com.bogdan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Model-View-Controller
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers (ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

}
