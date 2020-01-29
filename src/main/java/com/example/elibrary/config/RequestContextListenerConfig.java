package com.example.elibrary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

@Configuration
@WebFilter
public class RequestContextListenerConfig  extends RequestContextListener {


}
