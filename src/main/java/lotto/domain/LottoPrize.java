package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoPrize {

    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    NO_PRIZE(0, 0, false);

    private static final String describePrize = "%d개 일치%s (%s원)";
    private static final String additionalDescribeBonusPrize = ", 보너스 볼 일치";

    private final int matchCount;
    private final int prizeMoney;
    private final boolean isRequiredBonusNumber;

    LottoPrize(int matchCount, int prizeMoney, boolean isRequiredBonusNumber) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isRequiredBonusNumber = isRequiredBonusNumber;
    }

    public static LottoPrize of(long matchCount, boolean isRequiredBonusNumber) {
        return Arrays.stream(values())
                .filter(getPrizePredicate(matchCount, isRequiredBonusNumber))
                .findAny()
                .orElse(NO_PRIZE);
    }

    private static Predicate<LottoPrize> getPrizePredicate(long matchCount, boolean isRequiredBonusNumber) {
        return prize -> prize.matchCount == matchCount && (!prize.isRequiredBonusNumber || isRequiredBonusNumber);
    }

    @Override
    public String toString() {
        String formattedPrizeMoney = String.format("%,d", prizeMoney);
        if (SECOND_PRIZE.equals(this)) {
            return describePrize.formatted(matchCount, additionalDescribeBonusPrize, formattedPrizeMoney);
        }
        return describePrize.formatted(matchCount, "", formattedPrizeMoney);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
