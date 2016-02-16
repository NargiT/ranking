package fr.nargit.rank.servlet;

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
    packages("fr.nargit.rank.rest.v2")
        .register(JacksonFeature.class);
    ;
    ;
  }
}
