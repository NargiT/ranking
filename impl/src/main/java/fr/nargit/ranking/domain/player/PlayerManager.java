package fr.nargit.ranking.domain.player;

import java.util.List;

/**
 * (c) 22-janv.-2017
 *
 * @author tigran-mac
 */
public interface PlayerManager {
  List<Player> players();

  void enroll(Player newPlayer);

  void archive(Player existingPlayer);
}
