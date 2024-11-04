package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "미당첨");

    private final int matchCount;
    private final boolean needBonus;
    private final int prize;
    private final String description;

    Prize(int matchCount, boolean needBonus, int prize, String description) {
        this.matchCount = matchCount;
        this.needBonus = needBonus;
        this.prize = prize;
        this.description = description;
    }

    public static Prize of(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> !prize.needBonus || hasBonusNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}