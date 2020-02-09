package fr.nargit.ranking.rest.v1.entity;

/**
 * (c) 27-mars-2016
 *
 * @author tigran-mac
 */
public class Player {
  private final String username;
  private final String avatar;

  public Player(String username, String avatar) {
    this.username = username;
    this.avatar = avatar;
  }
}
