package fr.nargit.config.servlet;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * (c) 08-févr.-2016
 *
 * @author tigran-mac
 */
@ApplicationPath("api/v2")
public class ApplicationV2ResourceConfig extends ResourceConfig {

  public ApplicationV2ResourceConfig() {
    packages("fr.nargit.rest.resource.v2", "fr.nargit.exception.v2")
        .register(JacksonFeature.class);
    ;
    ;
  }
}
