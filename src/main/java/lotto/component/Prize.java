package lotto.component;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0);


    private final int correctNumberCount;
    private final boolean isBonusMatched;
    private final int prize;

    Prize(int matchCount, boolean isBonusMatched, int prize) {
        this.correctNumberCount = matchCount;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    Prize(int prize) {
        this(0, false, prize);
    }

    public static Prize getRank(LottoMatchCounts matchCounts) {
        int matchCount = matchCounts.getCorrectNumberCount();
        boolean isBonusMatched = matchCounts.isBonusMatched();

        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && isBonusMatched) return SECOND;
        if (matchCount == 5 && !isBonusMatched) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }
    public boolean isBonusMatched() {
        return isBonusMatched;
    }
    public int getPrize() {
        return prize;
    }
}
