package lotto.enums;
import static lotto.enums.BonusStatus.*;


public enum PrizeAmount {
    // 몇 개 매치 (볼 개수, 보너스 볼 여부, 상금, 당첨갯수)
    SIX_MATCH (6, BONUS_EXCLUDED, 2000000000, 0),
    FIVE_BONUS_MATCH (5, BONUS_INCLUDED, 30000000, 0),
    FIVE_MATCH (5, BONUS_EXCLUDED, 1500000, 0),
    FOUR_MATCH (4, BONUS_EXCLUDED, 50000, 0),
    THREE_MATCH (3, BONUS_EXCLUDED, 5000, 0);

    private final int matchCount;
    private final BonusStatus isBonus;
    private final int amount;
    private int count;

    PrizeAmount(int matchCount, BonusStatus isBonus, int amount, int count) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.amount = amount;
        this.count = count;
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

    public int getCount() { return count; }

    public void setCount(int count) {
        this.count = count;
    }
}
