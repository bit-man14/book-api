package pl.coderslab.app;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.coderslab.config.AppConfig;

public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    //private static final Logger log = LogManager.getLogger(AppInitializer.class);
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }
    
    @Override
    protected String[] getServletMappings() {
        //log.info("App started");
        return new String[]{"/"};
    }
}
