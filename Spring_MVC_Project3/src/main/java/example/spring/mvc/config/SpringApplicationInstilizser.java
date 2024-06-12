package example.spring.mvc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringApplicationInstilizser implements WebApplicationInitializer {
	
	private WebApplicationContext getContext()
	{
		System.out.println("Application is loading");
		AnnotationConfigWebApplicationContext webCtx=
				new AnnotationConfigWebApplicationContext();
		webCtx.setConfigLocations("example");
		//the above  code
		 return webCtx;
	}
	
	@Override
	public void onStartup(ServletContext servletContextRef) throws ServletException
	{
		WebApplicationContext webCtxRef= getContext();
		DispatcherServlet frontControllerRef = new DispatcherServlet(webCtxRef);
		ServletRegistration.Dynamic registration =
		servletContextRef.addServlet("frontController",frontControllerRef);
		registration.addMapping("/");
		
	}

}
