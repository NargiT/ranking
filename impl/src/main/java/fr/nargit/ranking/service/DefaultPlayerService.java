package fr.nargit.ranking.service;

import org.springframework.stereotype.Service;

/**
 * (c) 28-mars-2016
 *
 * @author tigran-mac
 */
@Service
public class DefaultPlayerService implements PlayerService {

  @Override
  public Integer getPlayer() {
    return 2;
  }
}
