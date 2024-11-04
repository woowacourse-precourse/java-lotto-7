package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    MISS(0, 0, false),
    ;

    private final int amount;
    private final int matchCount;
    private final boolean needBonusMatch;

    Prize(final int amount, final int mtachCount, final boolean needBonusMatch) {
        this.amount = amount;
        this.matchCount = mtachCount;
        this.needBonusMatch = needBonusMatch;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getNeedBonusMatch() {
        return this.needBonusMatch;
    }

    public static Prize of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> !prize.needBonusMatch || bonusMatch)
                .findFirst()
                .orElse(Prize.MISS);
    }
}
