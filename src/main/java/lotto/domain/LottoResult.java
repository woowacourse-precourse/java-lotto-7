package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRanking, Integer> result = new HashMap<>();

    public LottoResult() {
        for (LottoRanking rank : LottoRanking.values()) {
            result.put(rank, 0);
        }
    }

    public void addMatchCount(LottoRanking rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public LottoRanking findRanking(int matchCount, boolean checkBonusNumber) {
        for (LottoRanking rank : LottoRanking.values()) {
            if (rank.isMatchRanking(matchCount, checkBonusNumber)) {
                return rank;
            }
        }

        return LottoRanking.NOTHING;
    }
}
