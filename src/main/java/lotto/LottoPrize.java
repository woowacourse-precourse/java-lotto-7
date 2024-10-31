package lotto;

import java.util.Arrays;

public enum LottoPrize {

    MATCH_SIX(2_000_000_000, 6,  "6개 일치 (2,000,000,000원)"),
    MATCH_FIVE_AND_BONUS(30_000_000, 5,  "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_FIVE(1_500_000, 5,  "5개 일치 (1,500,000원)"),
    MATCH_FOUR(50_000, 4,  "4개 일치 (50,000원)"),
    MATCH_THREE(5_000, 3,  "3개 일치 (5,000원)"),
    MATCH_NONE(0, 0,  null),
    ;

    private final int amount;
    private final int matchCount;
    private final String description;

    LottoPrize(int amount, int matchCount, String description) {
        this.amount = amount;
        this.matchCount = matchCount;
        this.description = description;
    }

    public static LottoPrize match(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5) {
            if (isBonusMatch) {
                return LottoPrize.MATCH_FIVE_AND_BONUS;
            }
            return LottoPrize.MATCH_FIVE;
        }
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.matchCount == matchCount)
                .findFirst().orElse(LottoPrize.MATCH_NONE);
    }

    public int getAmount() {
        return this.amount;
    }
    public String getDescription() {
        return this.description;
    }

}
