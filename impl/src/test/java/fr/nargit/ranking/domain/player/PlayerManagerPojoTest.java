package fr.nargit.ranking.domain.player;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * (c) 22-janv.-2017
 *
 * @author tigran-mac
 */
public class PlayerManagerPojoTest {

  @Test
  public void players() {
    final PlayerManager playerManagerPojo = new PlayerManagerPojo();

    // when
    Assert.assertThat(playerManagerPojo.players(), Matchers.empty());
  }

  @Test
  public void enroll() {
    final PlayerManager playerManagerPojo = new PlayerManagerPojo();

    // when
    playerManagerPojo.enroll(new TestPlayer());

    // then
    Assert.assertThat(playerManagerPojo.players().size(), CoreMatchers.is(1));
  }

  @Test
  public void archive() {
    final PlayerManager playerManagerPojo = new PlayerManagerPojo();
    // when
    playerManagerPojo.enroll(new TestPlayer());
    playerManagerPojo.archive(new TestPlayer());

    // then
    Assert.assertThat(playerManagerPojo.players().size(), CoreMatchers.is(0));
  }

  @Test
  public void find() {
    final PlayerManager playerManagerPojo = new PlayerManagerPojo();

    Optional<Player> missingPlayer = playerManagerPojo.find("dude");
    TestPlayer newPlayer = new TestPlayer();
    playerManagerPojo.enroll(newPlayer);
    Optional<Player> player = playerManagerPojo.find(newPlayer.display_name());

    Assert.assertFalse(missingPlayer.isPresent());
    Assert.assertTrue(player.isPresent());
  }

  static class TestPlayer implements Player {

    @Override
    public Long id() {
      return 1L;
    }

    @Override
    public String display_name() {
      return "to";
    }

    @Override
    public Double score() {
      return 1.0;
    }

    @Override
    public int hashCode() {
      return 1;
    }

    @Override
    public boolean equals(Object obj) {
      return true;
    }
  }
}