package lotto.winning;

import java.util.Arrays;

public enum Rank {

    LOSING_TICKET(0, -1, false, ""),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - %d개"),
    FOURTH(50_000, 4, false, "4개 일치 (50,000원) - %d개"),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - %d개"),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - %d개");

    private final int prizeMoney;
    private final int matchingCount;
    private final boolean bonus;
    private final String message;


    Rank(int prizeMoney, int matchingCount, boolean bonus, String message) {
        this.prizeMoney = prizeMoney;
        this.matchingCount = matchingCount;
        this.bonus = bonus;
        this.message = message;
    }

    public int getProfit(int count) {
        return this.prizeMoney * count;
    }

    public String getMessage(int count) {
        return String.format(this.message, count);
    }

    public static Rank getWinningRank(int matchingCount, boolean bonus) {
        if (!bonus) {
            if (matchingCount == 0 || matchingCount == 1 || matchingCount == 2) {
                return LOSING_TICKET;
            }

        }

        return Arrays.stream(values())
                .filter(winning -> winning.matchingCount == matchingCount && winning.bonus == bonus)
                .findFirst()
                .orElseThrow(IllegalArgumentException :: new);
    }


}
