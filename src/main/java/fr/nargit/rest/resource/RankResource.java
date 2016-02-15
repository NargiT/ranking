package fr.nargit.rest.resource;

import fr.nargit.exception.BusinessException;
import fr.nargit.rest.resource.response.DummyObject;
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

    LOGGER.info("username {} ", username);
    LOGGER.warn("username {} ", username);
    LOGGER.error("username {} ", username);
    LOGGER.debug("username {} ", username);

    return new DummyObject(username, "hello");
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Path("{username}/exception")
  public DummyObject getGenericException(@PathParam("username") String username) {
    throw new IllegalArgumentException("you suck");
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Path("{username}/businesserror")
  public DummyObject getBusinessException(@PathParam("username") String username) throws BusinessException {
    throw new BusinessException(2, "you suck");
  }
}
