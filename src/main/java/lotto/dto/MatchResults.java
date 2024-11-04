package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.service.lotto.constant.LottoConstant;
import lotto.service.lotto.constant.MatchBonusEnum;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 1.
 */
public class MatchResults {
  private List<MatchResult> matchResults;
  private final Map<MatchResult, Integer> prize;
  private Map<MatchResult, Integer> dashboard;

  private static final MatchResult[] SORTED_MATCH_RESULTS = {
      MatchResult.from(3, MatchBonusEnum.DONT_CARE),
      MatchResult.from(4, MatchBonusEnum.DONT_CARE),
      MatchResult.from(5, MatchBonusEnum.NOT_MATCHED),
      MatchResult.from(5, MatchBonusEnum.MATCHED),
      MatchResult.from(6, MatchBonusEnum.DONT_CARE)
  };

  private MatchResults () {
    this.matchResults = new ArrayList<>();
    this.prize = initializePrizeMap();
    this.dashboard = initializeDashboardMap();
  }

  public static MatchResults from(MatchResults matchResults) {
  }

  private Map<MatchResult, Integer> initializePrizeMap() {
    Map<MatchResult, Integer> prizeMap = new EnumMap<>(MatchResult.class);
    prizeMap.put(MatchResult.from(3, MatchBonusEnum.DONT_CARE), LottoConstant.MATCH_THREE_PRIZE);
    prizeMap.put(MatchResult.from(4, MatchBonusEnum.DONT_CARE), LottoConstant.MATCH_FOUR_PRIZE);
    prizeMap.put(MatchResult.from(5, MatchBonusEnum.NOT_MATCHED), LottoConstant.MATCH_FIVE_PRIZE);
    prizeMap.put(MatchResult.from(5, MatchBonusEnum.MATCHED), LottoConstant.MATCH_FIVE_PRIZE);
    prizeMap.put(MatchResult.from(6, MatchBonusEnum.DONT_CARE), LottoConstant.MATCH_SIX_PRIZE);
    return Collections.unmodifiableMap(prizeMap);
  }

  private Map<MatchResult, Integer> initializeDashboardMap() {
    Map<MatchResult, Integer> dashboard = new EnumMap<>(MatchResult.class);
    for (MatchResult result : SORTED_MATCH_RESULTS) {
      dashboard.put(result, 0);
    }
    return dashboard;
  }

  public static MatchResults createMatchResults() {
    return new MatchResults();
  }

  public void add(MatchResult matchResult) {
    if (validatePrizeWorthy(matchResult)){
      dashboard.merge(matchResult, 1, Integer::sum);
      matchResults.add(matchResult);
    }
  }

  private boolean validatePrizeWorthy(MatchResult matchResult) {
    if (matchResult.matchCount() < LottoConstant.MINIMUM_MATCH_REQUIRED_FOR_PRIZE) {
      return false;
    }
    return true;
  }
}
