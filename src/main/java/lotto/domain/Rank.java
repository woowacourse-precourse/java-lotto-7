package lotto.domain;

import java.util.Arrays;

public enum Rank {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FOURTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  NONE(0, false, 0);

  private final int matchCount;
  private final boolean requiresBonus;
  private final int prizeAmount;

  Rank(int matchCount, boolean requiresBonus, int prizeAmount) {
    this.matchCount = matchCount;
    this.requiresBonus = requiresBonus;
    this.prizeAmount = prizeAmount;
  }

  public int getPrizeAmount() {
    return prizeAmount;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public static Rank getRank(int matchCount, boolean bonusMatch) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchCount == matchCount && rank.requiresBonus == bonusMatch)
        .findFirst()
        .orElse(NONE);
  }
}
