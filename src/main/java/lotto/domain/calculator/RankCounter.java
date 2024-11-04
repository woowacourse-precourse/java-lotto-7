package lotto.domain.calculator;

import lotto.domain.core.Rank;
import lotto.dto.result.MatchResults;
import lotto.dto.result.MatchResult;

import java.util.EnumMap;
import java.util.Map;

public class RankCounter {

    public Map<Rank, Integer> countRanks(MatchResults matchResults) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NO_MATCH) {
                rankCounts.put(rank, 0);
            }
        }

        for (MatchResult result : matchResults.results()) {
            Rank rank = Rank.from(result.matchCount(), result.hasBonus());
            if (rank != Rank.NO_MATCH) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        }

        return rankCounts;
    }
}
