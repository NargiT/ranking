package fr.nargit.ranking.player;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
}
