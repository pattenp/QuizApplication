package model;

/**
 * A Player has a id, name and score.
 * @author Patrik Larsson.
 */
public class Player {
  private final long id;
  private final String name;
  private final long score;

  public Player(long id, String name, long score) {
    this.id = id;
    this.name = name;
    this.score = score;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public long getScore() {
    return score;
  }
}
