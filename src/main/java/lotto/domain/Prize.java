package lotto.domain;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prizeAmount;

    Prize(int matchCount, boolean requiresBonus, int prizeAmount) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prizeAmount = prizeAmount;
    }
}
