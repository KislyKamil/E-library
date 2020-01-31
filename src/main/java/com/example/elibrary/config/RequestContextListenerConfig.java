package com.example.elibrary.config;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

@Configuration
@WebFilter
public class RequestContextListenerConfig  extends SpringBootServletInitializer {



    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }


    protected Filter[] getServletFilters() {
        return new Filter[] { new HiddenHttpMethodFilter() };
    }



}
