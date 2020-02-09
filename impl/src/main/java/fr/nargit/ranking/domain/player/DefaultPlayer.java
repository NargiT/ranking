package fr.nargit.ranking.player;

/**
 * (c) 28-mars-2016
 *
 * @author tigran-mac
 */
public class DefaultPlayer implements Player {

  private Integer id;
  private String name;

  public DefaultPlayer(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DefaultPlayer that = (DefaultPlayer) o;

    if (!id.equals(that.id)) return false;
    return name.equals(that.name);
  }

  @Override
  public Integer id() {
    return id;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Double score() {
    return 0.0;
  }
}
