package model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private int totalPrizeAmount;
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }
}
