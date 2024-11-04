package lotto.util;

/**
 * 등수와 관련된 상수
 */
public enum Ranks {
    NO_WIN(0, 0, BonusCondition.NOT_APPLICABLE, 0),
    FIRST(1, 6, BonusCondition.NOT_APPLICABLE, 2000000000),
    SECOND(2, 5, BonusCondition.WIN, 30000000),
    THIRD(3, 5, BonusCondition.LOSE, 1500000),
    FOURTH(4, 4, BonusCondition.NOT_APPLICABLE, 50000),
    FIFTH(5, 3, BonusCondition.NOT_APPLICABLE, 5000);

    private final int number; // 등수
    private final int matchCount; // 일치하는 번호 개수
    private final BonusCondition bonusCondition; // 보너스 번호 당첨 여부
    private final int prize; // 상금

    Ranks(int number, int matchCount, BonusCondition bonusCondition, int prize) {
        this.number = number;
        this.matchCount = matchCount;
        this.bonusCondition = bonusCondition;
        this.prize = prize;
    }

    public int getNumber() {
        return number;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BonusCondition getBonusCondition() {
        return bonusCondition;
    }

    public int getPrize() {
        return prize;
    }
}
