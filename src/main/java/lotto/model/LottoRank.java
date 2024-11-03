package lotto.model;

public enum LottoRank {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);


    private final int matchingNumberCount;
    private final boolean requireBonus;
    private final long money;

    LottoRank(int matchingNumberCount, boolean requireBonus, long money) {
        this.matchingNumberCount = matchingNumberCount;
        this.requireBonus = requireBonus;
        this.money = money;
    }

    public static LottoRank getRank(int matchingCount, boolean hasBonus) {
        if (matchingCount == SECOND.getMatchingNumberCount() && hasBonus) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.matchingNumberCount == matchingCount && !rank.requireBonus) {
                return rank;
            }
        }
        return NONE;
    }


    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public boolean getRequireBonus() {
        return requireBonus;
    }

    public long getMoney() {
        return money;
    }
}
