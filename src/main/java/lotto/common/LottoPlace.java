package lotto.common;

public enum LottoPlace {
    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(3, false, 5000);

    private int equalCount;
    private boolean bonusRequired;
    private int prize;

    LottoPlace(int equalCount, boolean bonusRequired, int prize) {
        this.equalCount = equalCount;
        this.prize = prize;
        this.bonusRequired = bonusRequired;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public boolean isBonusRequired() {
        return bonusRequired;
    }

    public int getPrize() {
        return prize;
    }
}
