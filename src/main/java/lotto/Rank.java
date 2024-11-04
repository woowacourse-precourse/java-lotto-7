package lotto;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public enum Rank {
    FIRST(6, false, BigDecimal.valueOf(2_000_000_000)),
    SECOND(5, true, BigDecimal.valueOf(30_000_000)),
    THIRD(5, false, BigDecimal.valueOf(1_500_000)),
    FOURTH(4, false, BigDecimal.valueOf(50_000)),
    FIFTH(3, false, BigDecimal.valueOf(5_000)),
    NONE(0, false, BigDecimal.ZERO);

    private static final String PRIZE_FORMAT_PATTERN = "#,###";

    private final int matchCount;
    private final boolean matchBonus;
    private final BigDecimal prize;

    Rank(int matchCount, boolean matchBonus, BigDecimal prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank from(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && hasBonusNumber) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        return new DecimalFormat(PRIZE_FORMAT_PATTERN).format(prize);
    }
}
