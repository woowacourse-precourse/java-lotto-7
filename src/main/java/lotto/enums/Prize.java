package lotto.enums;

public enum Prize {

    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

    private final int matchCount;
    private final boolean isBonus;
    private final int prizeMoney;
    Prize (int matchCount, boolean isBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrizeByMatchCountAndBonus(int matchCount, boolean isBonus) {
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && prize.isBonus == isBonus) {
                return prize;
            }
        }
        return null;
    }
}
