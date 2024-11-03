package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchedCount;
    private final boolean hasBonus;
    private final BigDecimal prize;

    Rank(int matchedCount, boolean bonus, long prize) {
        this.matchedCount = matchedCount;
        this.hasBonus = bonus;
        this.prize = BigDecimal.valueOf(prize);
    }

    // TODO: MISS를 반환하는게 맞는지
    public static Rank findByCountAndBonusNumber(int count, boolean isBonusMatched) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.matchedCount == count && rank.hasBonus == isBonusMatched)
            .findAny().orElse(MISS);
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
