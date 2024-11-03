package lotto.domain;

public enum Prize {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    FAIL(-1, false, 0);

    private int matchCount;
    private boolean isBonus;
    private int money;

    Prize(int matchCount, boolean isBonus, int money) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.money = money;
    }

    public static Prize getMatchPrize(int matchCount, boolean bonusFlag) {
        for (Prize value : Prize.values()) {
            if (value.matchCount == matchCount && value.isBonus == bonusFlag) {
                return value;
            }
        }

        return Prize.FAIL;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonus;
    }

    public int getMoney() {
        return money;
    }
}
