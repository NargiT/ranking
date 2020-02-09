package fr.nargit.ranking.spring;

import fr.nargit.ranking.domain.player.PlayerManager;
import fr.nargit.ranking.domain.player.PlayerManagerPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * (c) 28-mars-2016
 *
 * @author tigran-mac
 */
@Configuration
public class ApplicationConfig {

  @Bean
  public PlayerManager getPlayersManagerPojo() {
    return new PlayerManagerPojo();
  }
}
