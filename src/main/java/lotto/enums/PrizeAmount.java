package lotto.enums;

public enum PrizeAmount {
    // 몇 개 매치 (볼 개수, 보너스 볼 여부, 상금)
    SIX_MATCH (6, false, 2000000000),
    FIVE_BONUS_MATCH (5, true, 30000000),
    FIVE_MATCH (5, false, 1500000),
    FOUR_MATCH (4, false, 50000),
    THREE_MATCH (3, false, 5000);

    private final int matchCount;
    private final boolean isBonus;
    private final int amount;

    PrizeAmount(int matchCount, boolean isBonus, int amount) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public  boolean getIsBonus() {
        return isBonus;
    }

    public int getAmount() {
        return amount;
    }
}
