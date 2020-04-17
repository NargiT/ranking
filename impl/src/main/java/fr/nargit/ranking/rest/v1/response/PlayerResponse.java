package fr.nargit.ranking.rest.v1.response;

import fr.nargit.ranking.domain.player.Player;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * (c) 27-mars-2016
 *
 * @author tigran-mac
 */
@XmlRootElement
public class PlayerResponse {
  private Long playerId;
  private String username;
  private Long rank;
  private String avatar;

  public PlayerResponse() {
    // empty
  }

  public PlayerResponse(Player player) {
    this.playerId = player.id();
  }

  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Long getRank() {
    return rank;
  }

  public void setRank(Long rank) {
    this.rank = rank;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
