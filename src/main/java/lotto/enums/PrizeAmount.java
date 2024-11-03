package lotto.enums;
import static lotto.enums.BonusStatus.*;


public enum PrizeAmount {
    // 몇 개 매치 (볼 개수, 보너스 볼 여부, 상금, 당첨갯수)
    SIX_MATCH (6, BONUS_EXCLUDED, 2000000000),
    FIVE_BONUS_MATCH (5, BONUS_INCLUDED, 30000000),
    FIVE_MATCH (5, BONUS_EXCLUDED, 1500000),
    FOUR_MATCH (4, BONUS_EXCLUDED, 50000),
    THREE_MATCH (3, BONUS_EXCLUDED, 5000);

    private final int matchCount;
    private final BonusStatus isBonus;
    private final int amount;

    PrizeAmount(int matchCount, BonusStatus isBonus, int amount) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BonusStatus getIsBonus() {
        return isBonus;
    }

    public int getAmount() {
        return amount;
    }

}
