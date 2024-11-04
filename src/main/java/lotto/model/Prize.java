package lotto.model;

public enum Prize {
    FIRST_PRIZE(6, false, 2000000000),
    SECOND_PRIZE(5, true, 30000000),
    THIRD_PRIZE(5, false, 1500000),
    FOURTH_PRIZE(4, false, 50000),
    FIFTH_PRIZE(3, false, 5000),
    FAILURE(0, false, 0);

    private final int countOfMatchingNumbers;
    private final boolean bonusNumberMatch;
    private final int prizeMoney;

    Prize(int countOfMatchingNumbers, boolean bonusNumberMatch, int prizeMoney) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.bonusNumberMatch = bonusNumberMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getCountOfMatchingNumbers() {
        return countOfMatchingNumbers;
    }

    public boolean isBonusNumberMatch() {
        return bonusNumberMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize valueOf(int matchCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.countOfMatchingNumbers == matchCount && prize.bonusNumberMatch == bonusMatch) {
                return prize;
            }
        }

        return Prize.FAILURE;
    }
}
