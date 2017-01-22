package fr.nargit.ranking.spring;

import fr.nargit.ranking.service.DefaultPlayerService;
import fr.nargit.ranking.service.PlayerService;
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
  public PlayerService getPlayerService() {
    return new DefaultPlayerService();
  }
}
