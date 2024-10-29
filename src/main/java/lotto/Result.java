package lotto;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<LottoRank, Integer> matchResults;
    private int totalPrize;

    public Result() {
        matchResults = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            matchResults.put(rank, 0);
        }
    }

    public void addMatchResult(LottoRank rank) {
        if (rank != LottoRank.MISS) { // MISS 등수는 출력에서 제외
            matchResults.put(rank, matchResults.get(rank) + 1);
        }
        totalPrize += rank.getPrize();
    }

    public double calculateYield(int totalPrice) {
        if (totalPrice == 0) {
            return 0;
        }
        return ((double) totalPrize / totalPrice) * 100;
    }

    public Map<LottoRank, Integer> getMatchResults() {
        return matchResults;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
