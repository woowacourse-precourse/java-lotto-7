package lotto.model.lotto.prize;

import java.util.Arrays;

public enum LottoPrizeInfo {
    FIRST_PRIZE(6, false, 2_000_000_000L),
    SECOND_PRIZE(5, true, 30_000_000L),
    THIRD_PRIZE(5, false, 1_500_000L),
    FOURTH_PRIZE(4, false, 50_000L),
    FIFTH_PRIZE(3, false, 5_000L),
    NONE(0, false, 0L);

    public final int matchCount;
    public final boolean hasBonus;
    public final long prizeAmount;

    LottoPrizeInfo(int matchCount, boolean hasBonus, long prizeAmount) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prizeAmount = prizeAmount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoPrizeInfo getPrizeByMatch(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount && prize.hasBonus == hasBonus)
                .findFirst()
                .orElse(NONE);
    }
}
