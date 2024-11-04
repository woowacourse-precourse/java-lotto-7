package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public enum LottoRank {
    FIRST_PRIZE(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND_PRIZE(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PRIZE(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH_PRIZE(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH_PRIZE(3, 5_000, "3개 일치 (5,000원)"),
    NO_PRIZE(0, 0, "");

    private final int matchCount;
    private final int prizeAmount;
    private final String resultMessage;

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    LottoRank(int matchCount, int prizeAmount, String resultMessage) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.resultMessage = resultMessage;
    }

    public static LottoRank getRankOfEachLotto(int matchingNumbers, boolean isBonusNumberMatched) {
        if (SECOND_PRIZE.matchCount == matchingNumbers && !isBonusNumberMatched)
            return THIRD_PRIZE;
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.matchCount == matchingNumbers)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public static List<LottoRank> getRankValuesReversed() {
        return Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .filter(r -> r != NO_PRIZE)
                .toList();
    }

    public static Double getTotalReturn(LottoResult result) {
        double sum = 0;
        Map<LottoRank, Integer> stats = result.getResultStats();
        for (LottoRank rank : LottoRank.values()) {
            sum += (rank.getPrizeAmount() * stats.get(rank));
        }
        return sum;
    }
}
