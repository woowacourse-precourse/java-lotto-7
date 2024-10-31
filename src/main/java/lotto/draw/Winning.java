package lotto.draw;

import java.util.Arrays;
import java.util.List;

public enum Winning {

    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    LOSING_TICKET(0, 0 | 1 | 2, false);

    private final int prizeMoney;
    private final int matchingCount;
    private final boolean bonus;


    Winning(int prizeMoney, int matchingCount, boolean bonus) {
        this.prizeMoney = prizeMoney;
        this.matchingCount = matchingCount;
        this.bonus = bonus;
    }

    public int getProfit(int count) {
        return this.prizeMoney * count;
    }

    public static Winning getWinningRank(int matchingCount, boolean bonus) {
        if (bonus) {
            return SECOND;
        } else if (matchingCount == 0 || matchingCount == 1 || matchingCount == 2) {
            return LOSING_TICKET;
        }

        return Arrays.stream(values())
                .filter(winning -> winning.matchingCount == matchingCount && winning.bonus == bonus)
                .findFirst()
                .orElseThrow(IllegalArgumentException :: new);
    }
}
