package lotto.view;

public enum MatchLotto {
    NO_MATCH(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean bonusNumberCheck;
    private final int money;

    MatchLotto(int matchCount, boolean requiresBonus, int winMoney) {
        this.matchCount = matchCount;
        this.bonusNumberCheck = requiresBonus;
        this.money = winMoney;
    }

    public int getWinMoney() {
        return money;
    }

    public static MatchLotto getRank(int matchCount, boolean bonusMatch) {
        for (MatchLotto rank : MatchLotto.values()) {
            if (rank.matchCount == matchCount && rank.bonusNumberCheck == bonusMatch) {
                return rank;
            }
        }

        return NO_MATCH;
    }
}

