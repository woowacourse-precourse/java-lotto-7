package lotto.enums;

import lotto.constants.OutputViewConstants;

public enum Prize {

    FIFTH_PRIZE(3, false, 5000, OutputViewConstants.FIFTH_PRIZE),
    FOURTH_PRIZE(4, false, 50000, "FOURTH_PRIZE"),
    THIRD_PRIZE(5, false, 1500000, "THIRD_PRIZE"),
    SECOND_PRIZE(5, true, 30000000, "SECOND_PRIZE"),
    FIRST_PRIZE(6, false, 2000000000, "FIRST_PRIZE"),
    NON_PRIZE(0, false, 0, "NON_PRIZE");

    private final int matchCount;
    private final boolean isBonus;
    private final int prizeMoney;
    private final String prizeInfo;

    Prize (int matchCount, boolean isBonus, int prizeMoney, String prizeInfo) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
        this.prizeInfo = prizeInfo;
    }

    public static Prize getPrizeByMatchCountAndBonus(int matchCount, boolean isBonus) {
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && prize.isBonus == isBonus) {
                return prize;
            }
        }
        return NON_PRIZE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeInfo() {
        return prizeInfo;
    }
}
