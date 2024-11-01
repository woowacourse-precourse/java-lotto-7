package lotto.enums;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int count;
    private final boolean bonusMatch;
    private final int prize;

    Prize(int count, boolean bonusMatch, int prize) {
        this.count = count;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    public boolean matches(int commonCount, boolean bonus) {
        return this.count == commonCount && this.bonusMatch == bonus;
    }
}
