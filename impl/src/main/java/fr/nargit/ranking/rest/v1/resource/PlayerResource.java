package fr.nargit.ranking.rest.v1.resource;

import fr.nargit.ranking.player.PlayerManager;
import fr.nargit.ranking.rest.v1.entity.Player;
import fr.nargit.ranking.rest.v1.response.PlayerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("players")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PlayerResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);

  @Inject
  PlayerManager playerManager;

  @GET
  public List<PlayerResponse> getPlayers() {
    LOGGER.info("getPlayers()");
    return Arrays.asList(new PlayerResponse(), new PlayerResponse(), new PlayerResponse());
  }

  @GET
  @Path("{username}")
  public PlayerResponse getPlayers(@PathParam("username") String username) {
    LOGGER.info("id({})", username);
    return new PlayerResponse();
  }

  @POST
  public PlayerResponse createPlayer(fr.nargit.ranking.rest.v1.entity.Player player) {
    LOGGER.info("createPlayer()");
    return new PlayerResponse();
  }

  @PUT
  @Path("{username}")
  public PlayerResponse updatePlayer(@PathParam("username") String username, Player player) {
    LOGGER.info("updatePlayer({})", username);
    return new PlayerResponse();
  }

  @DELETE
  @Path("{username}")
  public Response removePlayer(@PathParam("username") String username) {
    LOGGER.info("removePlayer({})", username);
    return Response.accepted().build();
  }
}
