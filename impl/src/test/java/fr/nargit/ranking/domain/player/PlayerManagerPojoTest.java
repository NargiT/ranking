package fr.nargit.ranking.domain.player;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

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

  static class TestPlayer implements Player {

    @Override
    public Integer id() {
      return 1;
    }

    @Override
    public String name() {
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