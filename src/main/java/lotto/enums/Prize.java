package lotto.enums;

public enum Prize {
    FIFTH(3, false, 5000L),
    FOURTH(4, false, 50000L),
    THIRD(5, false, 1500000L),
    SECOND(5, true, 30000000L),
    FIRST(6, false, 2000000000L);


    private final int count;
    private final boolean bonusMatch;
    private final long prize;

    Prize(int count, boolean bonusMatch, long prize) {
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

    public long getPrize() {
        return prize;
    }

    public boolean matches(int commonCount, boolean bonus) {
        return (this.count == commonCount) && (this.bonusMatch == bonus);
    }
}
