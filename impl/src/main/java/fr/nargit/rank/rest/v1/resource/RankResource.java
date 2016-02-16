package fr.nargit.rank.rest.v1.resource;

import fr.nargit.rank.rest.v1.resource.response.DummyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("rank")
public class RankResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(RankResource.class);

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Path("{username}/normal")
  public DummyObject getIt(@PathParam("username") String username) {

    return new DummyObject(username, "hello");
  }
}
