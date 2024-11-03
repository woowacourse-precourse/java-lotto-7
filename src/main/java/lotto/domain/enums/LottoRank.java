package lotto.domain.enums;

import java.util.Arrays;

import static lotto.common.Number.FIVE;

public enum LottoRank {

    FIRST_RANK(6, false, 2_000_000_000),
    SECOND_RANK(5, true, 30_000_000),
    THIRD_RANK(5, false, 1_500_000),
    FOURTH_RANK(4, false, 50_000),
    FIFTH_RANK(3, false, 5_000),
    UN_RANK(0, false, 0);

    private final int matchCount;
    private final boolean isBonusMatched;
    private final int lotteryPrize;

    LottoRank(int matchCount, boolean isBonusMatched, int lotteryPrize) {
        this.matchCount = matchCount;
        this.isBonusMatched = isBonusMatched;
        this.lotteryPrize = lotteryPrize;
    }

    public static LottoRank findLottoRank(int count, boolean isBonusNumberMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> {
                    if (count == FIVE) {
                        return rank.isBonusMatched == isBonusNumberMatched;
                    }
                    return rank.matchCount == count;
                })
                .findFirst()
                .orElse(UN_RANK);
    }

    public int matchCount() {
        return matchCount;
    }

    public int lotteryPrize() {
        return lotteryPrize;
    }
}
