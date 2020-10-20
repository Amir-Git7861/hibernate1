package com.wellsfargo.swmd;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
		AnnotationConfigWebApplicationContext  appcontext=new AnnotationConfigWebApplicationContext();
		
		appcontext.register(BeanConfig.class);
		appcontext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic dyn=servletContext.addServlet("dispatcher",new DispatcherServlet(appcontext));
		dyn.setLoadOnStartup(1);
		dyn.addMapping("/");
		
		

	}

}
