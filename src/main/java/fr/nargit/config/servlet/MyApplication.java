package fr.nargit.config.servlet;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * (c) 08-févr.-2016
 *
 * @author tigran-mac
 */
@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {

  public MyApplication() {
    packages("fr.nargit.rest.resource", "fr.nargit.exception")
        .register(JacksonFeature.class);
    ;
    ;
  }
}
