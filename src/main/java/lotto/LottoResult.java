package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void winningResult(int matchCount, boolean bonusMatch) {
        LottoRank rank = getRank(matchCount, bonusMatch);
        if (rank != null) {
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
    }

    private LottoRank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return LottoRank.MATCH_6;
        if (matchCount == 5 && bonusMatch) return LottoRank.MATCH_5_WITH_BONUS;
        if (matchCount == 5) return LottoRank.MATCH_5;
        if (matchCount == 4) return LottoRank.MATCH_4;
        if (matchCount == 3) return LottoRank.MATCH_3;
        return null;
    }
    public int getCount(LottoRank rank) {
        return resultMap.getOrDefault(rank, 0);
    }

    public int totalWinningPrize() {
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += getCount(rank) * rank.getPrize();
        }
        return totalPrize;
    }
}