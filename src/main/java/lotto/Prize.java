package lotto;

public enum Prize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000),
    SECOND_PRIZE_BONUS(-1, 30000000); // -1 for bonus match case

    private final int matchingCount;
    private final int prizeMoney;

    Prize(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static int getPrizeMoneyByCount(int count) {
        for (Prize prize : values()) {
            if (prize.getMatchingCount() == count) {
                return prize.getPrizeMoney();
            }
        }
        return 0; // No prize found
    }
}
