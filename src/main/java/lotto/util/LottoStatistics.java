package lotto.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.LottoPrize;

public class LottoStatistics {
  private final Map<LottoPrize, Integer> statistics = new LinkedHashMap<>();

  public void addResult(int matchCount, boolean hasBonus) {
    LottoPrize prize = getPrize(matchCount, hasBonus);
    statistics.put(prize, statistics.getOrDefault(prize, 0) + 1);
  }
  public Map<LottoPrize, Integer> getStatistics() {
    return statistics;
  }


  private LottoPrize getPrize(int matchCount, boolean hasBonus) {
    switch (matchCount) {
      case 3:
        return LottoPrize.THREE_MATCH;
      case 4:
        return LottoPrize.FOUR_MATCH;
      case 5:
        return hasBonus ? LottoPrize.FIVE_MATCH_BONUS : LottoPrize.FIVE_MATCH;
      case 6:
        return LottoPrize.SIX_MATCH;
      default:
        return null;
    }
  }
}
