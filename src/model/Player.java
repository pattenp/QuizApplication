package model;

/**
 * A Player has a id, name and score.
 * @author Patrik Larsson.
 */
public class Player implements Comparable<Player> {
  private final long id;
  private final String name;
  private final int score;

  public Player(long id, String name, int score) {
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

  public int getScore() {
    return score;
  }


  @Override
  public int compareTo(Player player) {
    return score - player.score;
  }
}
