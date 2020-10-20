package com.wellsfargo.fsd.jw.listner;


import java.time.LocalDateTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletEventListner
 *
 */
@WebListener
public class ServletEventListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletEventListner() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("Server started @ " +LocalDateTime.now());
    }
	
}
