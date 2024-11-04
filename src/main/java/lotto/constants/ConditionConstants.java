package lotto.constants;

public enum ConditionConstants {

    FIFTH_PLACE(3, 0, 5_000),
    FOURTH_PLACE(4, 0, 50_000),
    THIRD_PLACE(5, 0, 1_500_000),
    SECOND_PLACE(5, 1, 30_000_000),
    FIRST_PLACE(6, 0, 2_000_000_000);

    private final int matchingNumbers;
    private final int bonusMatch;
    private final int prize;

    ConditionConstants(int matchingNumbers, int bonusMatch, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getNumbersConditions() {
        return matchingNumbers;
    }

    public int getBonusConditions() {
        return bonusMatch;
    }

    public int getPrizeConditions() {
        return prize;
    }
}
