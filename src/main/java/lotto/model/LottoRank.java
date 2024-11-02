package lotto.model;

public enum LottoRank {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000);

    private final int rank;
    private final int matchingNumberCount;
    private final boolean requireBonus;
    private final long money;

    LottoRank(int rank, int matchingNumberCount, boolean requireBonus, long money) {
        this.rank = rank;
        this.matchingNumberCount = matchingNumberCount;
        this.requireBonus = requireBonus;
        this.money = money;
    }

    public int getRank() {
        return rank;
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
