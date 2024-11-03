package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;

public enum LottoPrize {
    NO_PRIZE(0, false, 0),
    THREE_MATCHES(3, false, 5_000),
    FOUR_MATCHES(4, false, 50_000),
    FIVE_MATCHES(5, false, 1_500_000),
    FIVE_MATCHES_WITH_BONUS(5, true, 30_000_000),
    SIX_MATCHES(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchedBonus;
    private final int prizeAmount;

    LottoPrize(int matchCount, boolean matchedBonus, int prizeAmount) {
        this.matchCount = matchCount;
        this.matchedBonus = matchedBonus;
        this.prizeAmount = prizeAmount;
    }

    public static LottoPrize getLottoPrize(int matchCount, boolean matchedBonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == matchCount && prize.matchedBonus == matchedBonus)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        String formattedPrizeAmount = formatter.format(prizeAmount);

        if (matchedBonus) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + formattedPrizeAmount + "원) - ";
        }
        return matchCount + "개 일치 (" + formattedPrizeAmount + "원) - ";
    }
}
