package lotto.model;

public enum LottoRank {
    FIRST(1, 6, false,"(2,000,000,000원)",2000000000),
    SECOND(2, 5, true,"(30,000,000원)",30000000),
    THIRD(3, 5, false,"(1,500,000원)",1500000),
    FOURTH(4, 4, false,"(50,000원)",50000),
    FIFTH(5, 3, false,"(5,000원)",5000);

    private final int rank;
    private final int matchingCount;
    private final boolean requiresBonus;
    private final String prizeNotice;
    private final int prize;

    LottoRank(int rank, int matchingCount, boolean requiresBonus,String prizeNotice,int prize) { // private 추가
        this.rank = rank;
        this.matchingCount = matchingCount;
        this.requiresBonus = requiresBonus;
        this.prizeNotice = prizeNotice;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }

    public String getPrize() {
        return prizeNotice;
    }

    public int getPrizeCount() {
        return prize;
    }
}
