package lotto.domain;

import lotto.dto.MatchCondition;
import lotto.enums.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            this.rankCounts.put(rank, 0);
        }
    }

    public Map<LottoRank, Integer> produceStatistics(List<MatchCondition> matchConditions) {

        for (MatchCondition matchCondition : matchConditions) {
            LottoRank rank = LottoRank.of(matchCondition.matchCount(), matchCondition.containBonusNumber());
            rankCounts.computeIfPresent(rank, (key, count) -> count + 1);
        }
        return rankCounts;
    }
}

