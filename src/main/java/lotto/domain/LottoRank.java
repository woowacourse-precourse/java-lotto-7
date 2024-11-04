package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private final int matchCount;
    private final int money;

    LottoRank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            return matchBonus ? SECOND : THIRD;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(FAIL);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return money;
    }
}
