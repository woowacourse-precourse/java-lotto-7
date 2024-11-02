package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum WinningPrize {
    NONE(0, 0, 0),
    FIFTH(3, 0, 5_000),
    FOURTH(4, 0, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND(5, 1, 30_000_000),
    FIRST(6, 0, 2_000_000_000);

    private final int matches;
    private final int bonus;
    private final long prizeMoney;

    WinningPrize(int matches, int bonus, long prizeMoney) {
        this.matches = matches;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    static WinningPrize getPrize(int matches, int bonus) {
        return Arrays.stream(values())
                .filter(prize -> isMatch(prize, matches, bonus))
                .max(Comparator.comparingLong(WinningPrize::getPrizeMoney))
                .orElse(NONE);
    }

    private static boolean isMatch(WinningPrize prize, int matches, int bonus) {
        return prize.matches == matches && prize.bonus <= bonus;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        if (bonus > 0) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원)", matches, prizeMoney);
        }
        return String.format("%d개 일치 (%,d원)", matches, prizeMoney);
    }
}