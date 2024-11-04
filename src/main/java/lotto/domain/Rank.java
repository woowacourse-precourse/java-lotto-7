package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
  FIRST(6, false, 2_000_000_000L, "6개 일치"), SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치"), THIRD(
      5, false, 1_500_000L, "5개 일치"), FOURTH(4, false, 50_000L, "4개 일치"), FIFTH(3, false, 5_000L,
      "3개 일치"), MISS(0, false, 0L, "");

  private final int matchCount;
  private final boolean matchBonus;
  private final long prize;
  private final String matchMessage;

  Rank(int matchCount, boolean matchBonus, long prize, String matchMessage) {
    this.matchCount = matchCount;
    this.matchBonus = matchBonus;
    this.prize = prize;
    this.matchMessage = matchMessage;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean isMatchBonus() {
    return matchBonus;
  }

  public long getPrize() {
    return prize;
  }

  public String getMatchMessage() {
    return matchMessage;
  }

  public static Rank valueOf(int matchCount, boolean matchBonus) {
    if (matchCount == FIRST.matchCount) {
      return FIRST;
    }
    if (matchCount == SECOND.matchCount && matchBonus) {
      return SECOND;
    }
    if (matchCount == THIRD.matchCount) {
      return THIRD;
    }
    if (matchCount == FOURTH.matchCount) {
      return FOURTH;
    }
    if (matchCount == FIFTH.matchCount) {
      return FIFTH;
    }
    return MISS;
  }

  public static List<Rank> getWinningRanks() {
    return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
  }
}
