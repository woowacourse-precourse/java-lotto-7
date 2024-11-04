package lotto;

public enum Prize {
    NOPRIZE_ZERP(0, 0L,false),
    NOPRIZE_ONE(1, 0L,true),
    NOPRIZE_TWO(2, 0L,true),
    PRIZE_5(3, 5000L,true),
    PRIZE_4(4, 50000L,true),
    PRIZE_3(5, 1500000L,true),
    PRIZE_2(5, 30000000L,false),
    PRIZE_1(6, 2000000000L,false);


    private final int matchCount;
    private final long prizeAmount;
    private final boolean bonusMatch;

    Prize(int matchCount, long prizeAmount,boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}
