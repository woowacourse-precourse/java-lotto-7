package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {

  private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

  public Result() {
    for (Rank rank : Rank.values()) {
      rankCounts.put(rank, 0);
    }
  }

  public void addRank(Rank rank) {
    rankCounts.put(rank, rankCounts.get(rank) + 1);
  }

  public int getRankCount(Rank rank) {
    return rankCounts.get(rank);
  }

  public long calculateTotalPrize() {
    long total = 0;
    for (Rank rank : Rank.values()) {
      total += rank.getPrize() * rankCounts.get(rank);
    }
    return total;
  }
}
