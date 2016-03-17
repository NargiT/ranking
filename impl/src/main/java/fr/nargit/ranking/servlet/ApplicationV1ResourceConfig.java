package fr.nargit.ranking.servlet;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * (c) 08-févr.-2016
 *
 * @author tigran-mac
 */
@ApplicationPath("api/v1")
public class ApplicationV1ResourceConfig extends ResourceConfig {

  public ApplicationV1ResourceConfig() {
    packages("fr.nargit.ranking.rest.v1")
        .register(JacksonFeature.class);
    ;
    ;
  }
}
