package lotto.model;

public enum LottoRank {
    FIRST( 6, false,"(2,000,000,000원)",2000000000),
    SECOND( 5, true,"(30,000,000원)",30000000),
    THIRD(5, false,"(1,500,000원)",1500000),
    FOURTH( 4, false,"(50,000원)",50000),
    FIFTH( 3, false,"(5,000원)",5000);

    private final int matchingCount;
    private final boolean matchingBonus;
    private final String prizeNotice;
    private final int prize;

    LottoRank( int matchingCount, boolean matchingBonus,String prizeNotice,int prize) {
        this.matchingCount = matchingCount;
        this.matchingBonus = matchingBonus;
        this.prizeNotice = prizeNotice;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean getMatchingBonus() {
        return matchingBonus;
    }

    public String getPrizeNotice() {
        return prizeNotice;
    }

    public int getPrize() {
        return prize;
    }
}
