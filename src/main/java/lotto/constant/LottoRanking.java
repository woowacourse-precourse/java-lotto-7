package lotto.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoRanking {

    NONE_RANK(0, false, 0),
    FIFTH_RANK(3, false, 5000),
    FOURTH_RANK(4, false, 50000),
    THIRD_RANK(5, false, 150000),
    SECOND_RANK(6, true, 30000000),
    FIRST_RANK(6, false, 2000000000);

    private final int correctCount;
    private final boolean needBonusNumber;
    private final int prize;

    LottoRanking(int correctCount, boolean needBonusNumber, int prize) {
        this.correctCount = correctCount;
        this.needBonusNumber = needBonusNumber;
        this.prize = prize;
    }

    public static LottoRanking matchingLottoRanking(int correctCount, boolean hasBonusNumber) {
        for (LottoRanking ranking : values()) {
            if (ranking.correctCount == correctCount &&
                    (ranking.needBonusNumber == hasBonusNumber || !ranking.needBonusNumber)) {
                return ranking;
            }
        }
        return NONE_RANK;
    }

    public static Map<LottoRanking, Integer> getDefaultRankingStates() {

        Map<LottoRanking, Integer> results = new HashMap<>();

        for (LottoRanking ranking : LottoRanking.values()) {
            results.put(ranking, 0);
        }

        return results;
    }

    public int getPrize() {
        return prize;
    }
}
