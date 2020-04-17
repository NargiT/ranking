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
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Path("players")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PlayerResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);

  @Inject
  private PlayerManager playerManager;

  @GET
  public List<PlayerResponse> findPlayers() {
    LOGGER.info("All players.");
    return playerManager.players().stream().map(p -> {
      PlayerResponse playerResponse = new PlayerResponse();
      playerResponse.setUsername(p.display_name());
      return playerResponse;
    }).collect(Collectors.toList());
  }

  @GET
  @Path("{username}")
  public PlayerResponse findPlayer(@PathParam("username") String username) {
    LOGGER.info("Find player [{}].", username);
    Optional<Player> player = playerManager.find(username);
    return player.map(PlayerResponse::new).orElseGet(PlayerResponse::new);
  }

  @POST
  public PlayerResponse createPlayer(fr.nargit.ranking.rest.v1.entity.Player player) {
    LOGGER.info("New player {}", player.getUsername());
    Random random = new Random(Instant.now().toEpochMilli());
    DefaultPlayer newPlayer = new DefaultPlayer(random.nextLong(), player.getUsername());
    playerManager.enroll(newPlayer);
    return new PlayerResponse(newPlayer);
  }

  @PUT
  @Path("{username}")
  public PlayerResponse updatePlayer(@PathParam("username") String username, Player player) {
    LOGGER.info("Update player {}", username);
    throw new ServerErrorException("This is not yet ready", Response.Status.NOT_IMPLEMENTED);
  }

  @DELETE
  @Path("{username}")
  public Response removePlayer(@PathParam("username") String username) {
    LOGGER.info("Remove player {}", username);
    throw new ServerErrorException("This is not yet ready", Response.Status.NOT_IMPLEMENTED);
  }

}
