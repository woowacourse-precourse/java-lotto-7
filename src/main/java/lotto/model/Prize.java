package lotto.model;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private int count;
    private boolean bonusNumber;
    private int prizeMoney;

    Prize(int count, boolean bonusNumber, int prizeMoney) {
        this.count = count;
        this.bonusNumber = bonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusNumber() {
        return bonusNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
