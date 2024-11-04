package lotto.global.enums;

public enum Prize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000, true),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int amount;
    private final boolean requiresBonus;

    Prize(int matchCount, int amount) {
        this(matchCount, amount, false);
    }

    Prize(int matchCount, int amount, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }
}
