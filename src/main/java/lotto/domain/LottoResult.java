package lotto.domain;

import lotto.domain.enums.LottoPrize;
import lotto.domain.enums.LottoRank;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {

    private final EnumMap<LottoRank, Integer> rankResult;

    private LottoResult(EnumMap<LottoRank, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public static LottoResult of(List<MatchResult> matchResults) {
        EnumMap<LottoRank, Integer> rankResult = InitializedRankResult();
        updateRankResult(rankResult, matchResults);
        return new LottoResult(rankResult);
    }

    private static EnumMap<LottoRank, Integer> InitializedRankResult() {
        EnumMap<LottoRank, Integer> rankResult = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }

    private static void updateRankResult(EnumMap<LottoRank, Integer> rankResult, List<MatchResult> matchResults) {
        for (MatchResult matchResult : matchResults) {
            LottoRank rank = LottoRank.fromMatchCount(matchResult.getMatchCount(), matchResult.isMatchBonus());
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
    }

    public long calculateTotalPrize() {
        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            LottoPrize prize = LottoPrize.fromRank(rank);
            totalPrize += (long) rankResult.get(rank) * prize.getPrize();
        }
        return totalPrize;
    }

    public EnumMap<LottoRank, Integer> getRankResult() {
        return rankResult;
    }
}
