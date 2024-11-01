package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(0, 0, 0);

    private final int matches;
    private final int bonus;
    private final long prizeMoney;

    LottoPrize(int matches, int bonus, long prizeMoney) {
        this.matches = matches;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    static LottoPrize getPrize(int matches, int bonus) {
        return Arrays.stream(values())
                .filter(prize -> isMatch(prize, matches, bonus))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatch(LottoPrize prize, int matches, int bonus) {
        return prize.matches == matches && prize.bonus <= bonus;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}