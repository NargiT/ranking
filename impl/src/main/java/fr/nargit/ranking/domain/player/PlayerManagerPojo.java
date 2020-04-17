package fr.nargit.ranking.domain.player;

import java.util.*;

/**
 * (c) 22-janv.-2017
 *
 * @author tigran-mac
 */
public class PlayerManagerPojo implements PlayerManager {

  private Set<Player> players;

  public PlayerManagerPojo() {
    players = new HashSet<>();
  }

  @Override
  public List<Player> players() {
    return new LinkedList<>(players);
  }

  @Override
  public void enroll(Player newPlayer) {
    players.add(newPlayer);
  }

  @Override
  public void archive(Player existingPlayer) {
    players.remove(existingPlayer);
  }

  @Override
  public Optional<Player> find(String name) {
    Player foundPlayer = null;
    for (Player player : players) {
      if (foundPlayer == null && player.display_name().equalsIgnoreCase(name)) {
        foundPlayer = player;
      }
    }
    return Optional.ofNullable(foundPlayer);
  }

}
