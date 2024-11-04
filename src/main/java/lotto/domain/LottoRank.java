package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;

    LottoRank(int matchCount, boolean bonusRequired, int prize) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public static LottoRank determineRank(int matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusRequired == bonusMatch)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }
}
