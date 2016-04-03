package fr.nargit.ranking.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * (c) 28-mars-2016
 * <p/>
 * Allow to initialize Spring without applicationContext.xml
 *
 * @author tigran-mac
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomSpringContextInitializer implements WebApplicationInitializer {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomSpringContextInitializer.class);

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    if (servletContext.getInitParameter("contextConfigLocation") == null) {
      LOGGER.info("Start CustomSpringContextInitializer intizializer");
      servletContext.setInitParameter("contextConfigLocation", "fr.nargit.ranking.config");
      WebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
      servletContext.addListener(new ContextLoaderListener(rootAppContext));
    } else {
      LOGGER.info("contextConfigLocation is already define, skipping this initialization");
    }
  }
}
