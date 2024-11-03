package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 0, 2000000000),
    SECOND(5, true, 1, 30000000),
    THIRD(5, false, 2, 1500000),
    FOURTH(4, false, 3, 50000),
    FIFTH(3, false, 4, 5000),
    NO_WIN(0, false, -1, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int index;
    private final int money;

    LottoRank(int matchCount, boolean requiresBonus, int index, int money) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.index = index;
        this.money = money;
    }

    public static LottoRank getRank(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount != matchCount) {
                continue;
            }
            if (matchCount == 5 && rank.requiresBonus != bonusMatch) {
                continue;
            }
            return rank;
        }
        return NO_WIN;
    }

    public int getIndex() {
        return index;
    }

    public int getMoney() {
        return money;
    }

}
