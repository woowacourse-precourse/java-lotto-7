package lotto.domain.core;

public enum Prize {
    NO_MATCH(0),
    THREE_MATCH(5_000),
    FOUR_MATCH(50_000),
    FIVE_MATCH(1_500_000),
    FIVE_MATCH_WITH_BONUS(30_000_000),
    SIX_MATCH(2_000_000_000);

    private final int amount;

    Prize(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
