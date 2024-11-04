package lotto.domain.lotto.vo;

import java.util.Arrays;

public enum LottoPrize {
    LOSE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingNumberCount;
    private final boolean isBonusMatched;
    private final int prizeAmount;

    LottoPrize(int matchCount, boolean isBonusMatched, int prizeAmount) {
        this.matchingNumberCount = matchCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeAmount = prizeAmount;
    }

    public static LottoPrize of(int matchingNumbers, boolean isBonusMatched) {
        return Arrays.stream(values())
            .filter(prize -> prize.matchingNumberCount == matchingNumbers &&
                (matchingNumbers < 5 || prize.isBonusMatched == isBonusMatched))
            .findFirst()
            .orElse(LOSE);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
