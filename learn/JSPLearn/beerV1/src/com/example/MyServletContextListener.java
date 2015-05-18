package com.example;
import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent event){
        ServletContext context=event.getServletContext();
        String dogBreed=context.getInitParameter("breed");
        Dog d=new Dog(dogBreed);
        context.setAttribute("dog",d);
    }

    public void contextDestroyed(ServletContextEvent event){

    }
}