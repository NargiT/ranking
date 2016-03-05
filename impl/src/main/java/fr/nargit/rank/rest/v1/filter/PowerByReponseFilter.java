package fr.nargit.rank.rest.v1.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * (c) 17-févr.-2016
 *
 * @author tigran-mac
 */
public class PowerByReponseFilter implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws
      IOException {
    responseContext.getHeaders().add("X-Powered-By", "Tigran Tch");
  }
}
