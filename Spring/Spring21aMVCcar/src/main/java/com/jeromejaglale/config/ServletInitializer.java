package com.jeromejaglale.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[0]; 
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
}

//    @Override
//    protected void registerContextLoaderListener(ServletContext servletContext) {
//        super.registerContextLoaderListener(servletContext);    //To change body of overridden methods use File | Settings | File Templates.
//    }
//    
//    @Override 
//    public void onStartup(ServletContext servletContext) throws ServletException { 
//        super.onStartup(servletContext); 
//        this.registerRequestContextListener(servletContext); 
//    } 
// 
//    private void registerRequestContextListener(ServletContext servletContext) { 
//        servletContext.addListener(new RequestContextListener()); 
//    }     
	
//	  @Override
//	  protected void customizeRegistration(Dynamic registration) {
//	    registration.setInitParameter("dispatchOptionsRequest", "true");
//	  }

//	  @Override
//	  protected void registerDispatcherServlet(ServletContext servletContext) {
//	      super.registerDispatcherServlet(servletContext);
//
//	      servletContext.addListener(new HttpSessionEventPublisher());
//
//	  }
	  
//	  @Override
//	  protected WebApplicationContext createRootApplicationContext() {
//	      AnnotationConfigWebApplicationContext appContext = (AnnotationConfigWebApplicationContext)super.createRootApplicationContext();
//
////	      String profile;
////	       profile = "brett";
////
////	       appContext.getEnvironment().setActiveProfiles(profile);
//	       return appContext;
//	  }
	
