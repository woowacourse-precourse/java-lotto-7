package lotto;

import java.math.BigDecimal;

public enum Rank {
    FIRST(6, false, BigDecimal.valueOf(2_000_000_000)),
    SECOND(5, true, BigDecimal.valueOf(30_000_000)),
    THIRD(5, false, BigDecimal.valueOf(1_500_000)),
    FOURTH(4, false, BigDecimal.valueOf(50_000)),
    FIFTH(3, false, BigDecimal.valueOf(5_000)),
    NONE(0, false, BigDecimal.ZERO);

    private final int matchCount;
    private final boolean matchBonus;
    private final BigDecimal prize;

    Rank(int matchCount, boolean matchBonus, BigDecimal prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }
}
