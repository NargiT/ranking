package fr.nargit.ranking.rest.v1.resource;

import fr.nargit.ranking.domain.player.DefaultPlayer;
import fr.nargit.ranking.domain.player.Player;
import fr.nargit.ranking.domain.player.PlayerManager;
import fr.nargit.ranking.rest.v1.response.PlayerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("players")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PlayerResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);

  @Inject
  private PlayerManager playerManager;

  @GET
  public List<PlayerResponse> getPlayers() {
    LOGGER.info("getPlayers()");
    Player player = new DefaultPlayer(12, "jean");
    playerManager.enroll(player);
    return playerManager.players().stream().map(p -> {
      PlayerResponse playerResponse = new PlayerResponse();
      playerResponse.setUsername(p.name());
      return playerResponse;
    }).collect(Collectors.toList());
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
