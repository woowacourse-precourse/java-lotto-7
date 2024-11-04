package lotto.model;

import java.math.BigDecimal;

public enum LottoPrize {
    THREE_MATCH(3, BigDecimal.valueOf(5000)),
    FOUR_MATCH(4, BigDecimal.valueOf(50000)),
    FIVE_MATCH(5, BigDecimal.valueOf(1500000)),
    FIVE_MATCH_WITH_BONUS(5, BigDecimal.valueOf(30000000), true),
    SIX_MATCH(6, BigDecimal.valueOf(2000000000));

    private final int matchCount;
    private final BigDecimal prizeAmount;
    private final boolean isBonusRequired;

    LottoPrize(int matchCount, BigDecimal prizeAmount) {
        this(matchCount, prizeAmount, false);
    }

    LottoPrize(int matchCount, BigDecimal prizeAmount, boolean isBonusRequired) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.isBonusRequired = isBonusRequired;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isBonusRequired() {
        return isBonusRequired;
    }
}
